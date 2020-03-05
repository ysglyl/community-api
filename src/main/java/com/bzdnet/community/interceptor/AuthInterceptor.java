package com.bzdnet.community.interceptor;

import com.bzdnet.community.exception.UnLoginException;
import com.bzdnet.community.util.FuncTool;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Data
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String token = request.getHeader("Authorization");

        // 未登录
        if (FuncTool.isEmptyString(token)) {
            throw new UnLoginException(0);
        }

        return true;
    }

}
