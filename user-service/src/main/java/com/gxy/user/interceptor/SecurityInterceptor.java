package com.gxy.user.interceptor;

import com.gxy.annotation.NeedLogin;
import com.gxy.client.base.Constant;
import com.gxy.client.base.SessionUserVO;
import com.gxy.client.base.SessionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            NeedLogin annotation = method.getMethod().getAnnotation(NeedLogin.class);
            if(annotation!=null){
                String userId = request.getHeader(Constant.userId);
                String phone = request.getHeader("phone");
                SessionUtils.setUserInfo(new SessionUserVO(userId,phone));
            }
        }
        return true;
    }
}
