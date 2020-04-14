package com.gxy.user.service.impl;

import com.gxy.client.base.CommonResult;
import com.gxy.user.service.LoginService;
import com.gxy.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    TokenService tokenService;
    @Override
    public CommonResult<Map> doLogin(String userName, String passsWord) {
        HttpHeaders headers =new HttpHeaders();
        headers.set("username",userName);
        headers.set("password",passsWord);
        headers.set("grant_type","password");
        headers.set("scope","all");
        Map map = tokenService.doLogin(headers);
        return CommonResult.successReturn(map);
    }
}
