package edu.cuit.questionnaire.web.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomUserFilter extends UserFilter {

    // 如果以以下字符串为前缀的uri不保存
    private static final String[] NO_SAVE_PREFIX = {"login", "register",
        "pwdauth"};

    protected final Logger logger = LoggerFactory
            .getLogger(CustomUserFilter.class);

    /**
     * 重写认证失败时的保存request策略
     */
    @Override
    protected void saveRequest(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        // 　判断是否为ajax请求,如果是ajax请求则不保存request
        if (req.getHeader("x-requested-with") != null) {
            return;
        }
        String uri = req.getServletPath();

        for (String prefix : NO_SAVE_PREFIX) {
            if (uri.startsWith(prefix, 1)) {
                return;
            }
        }
        WebUtils.saveRequest(request);
    }
}
