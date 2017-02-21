package com.dream.boot.interceptors;

import com.dream.boot.annotations.LoginRequired;
import com.dream.boot.session.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Slf4j
public class SiteACLInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    protected UserSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String currentUrl = request.getRequestURL().toString();

        if (currentUrl.endsWith("/login")) {
            response.sendRedirect("/site/login");
            return false;
        } else {
            if (handler instanceof HandlerMethod) {

                HandlerMethod method = (HandlerMethod) handler;

                if (method.getMethodAnnotation(LoginRequired.class) != null || method.getBeanType().getDeclaredAnnotation(LoginRequired.class) != null) {
                    if (!session.isLogined()) {
                        response.sendRedirect("/site/login");
                        return false;
                    }
                }
            }
        }

        return true;
    }


}
