package com.bzdnet.community.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bzdnet.community.exception.UnLoginException;
import com.bzdnet.community.holder.SessionContextHolder;
import com.bzdnet.community.model.UserModel;
import com.bzdnet.community.service.UserService;
import com.bzdnet.community.util.FuncTool;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String openId = request.getHeader("openId");
        if(FuncTool.isNotEmptyString(openId)) {
            UserModel user = userService.getOne(new QueryWrapper<UserModel>().eq("open_id_", openId));
            if(user!= null){
                SessionContextHolder.set(user);
            }
        }
        return true;
    }

}
