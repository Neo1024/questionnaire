package edu.cuit.questionnaire.web.shiro.realm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.cuit.questionnaire.model.account.User;
import edu.cuit.questionnaire.service.account.UserService;
import edu.cuit.questionnaire.util.Encoders;

public class ShiroDbRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Resource
    private UserService userService;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.findByEmail(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();// 没找到帐号
        }
        byte[] salt = Encoders.decodeHex(user.getSalt());
        return new SimpleAuthenticationInfo(user, user.getPasswd(),
                ByteSource.Util.bytes(salt), getName());
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
//        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole(user.getRoles());
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
                Encoders.HASH_ALGORITHM);
        matcher.setHashIterations(Encoders.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }
}
