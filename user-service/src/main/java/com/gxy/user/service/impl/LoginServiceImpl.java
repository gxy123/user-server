package com.gxy.user.service.impl;

import com.gxy.client.base.CommonResult;
import com.gxy.service.base.BaseServiceAOImpl;
import com.gxy.user.service.LoginService;
import com.gxy.user.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    TokenService tokenService;
    @Override
    public CommonResult<Map> doLogin(String userName, String passsWord) {
        log.info("通过账号密码获取token...");
        HttpHeaders headers =new HttpHeaders();
        headers.set("username",userName);
        headers.set("password",passsWord);
        headers.set("grant_type","password");
        headers.set("scope","all");
        Map map = tokenService.doLogin(headers);
        return CommonResult.successReturn(map);
    }

    @Override
    public CommonResult<Map> doLoginCode(String code,String id) {
        log.info("通过授权码获取token...");
        HttpHeaders headers =new HttpHeaders();
        headers.set("code",code);
        headers.set("redirect_uri","http://localhost/user-api/api/syuser/receiveCode?id="+id);
        headers.set("grant_type","authorization_code");
        headers.set("scope","all");
        Map map = tokenService.doLogin(headers);
        return CommonResult.successReturn(map);
    }
}
