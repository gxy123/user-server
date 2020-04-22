package com.gxy.user.interceptor;

import com.gxy.client.base.Constant;
import com.gxy.client.base.SessionUserVO;
import com.gxy.client.base.SessionUtils;
import com.gxy.service.filter.HttpRequestBaseAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Order(1)
@Aspect
@Configuration
public class SecurityInterceptor{
    private static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);
    @Pointcut("@annotation(com.gxy.annotation.NeedLogin)")
    public void pointcut() {}
    @Before("pointcut()")
    public void before(JoinPoint point) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        String userId = request.getHeader(Constant.userId);
        String phone = request.getHeader("phone");
        log.info("获取当前登陆人信息...");
        SessionUtils.setUserInfo(new SessionUserVO(userId,phone));
    }

}
