package edu.cuit.questionnaire.web.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * 过滤用户登录后不能访问的页面<br>
 */
public class NoLoginAccessFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
            ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 如果用户已经是登录状态，访问拒绝
        if (SecurityUtils.getSubject().isAuthenticated()) {
            resp.sendRedirect(req.getContextPath());
        }
        // 如果用了resp.sendRedirect(req.getContextPath());这里只能返回true
        return true;
    }

}
