package com.gxy.user.service;

import com.gxy.client.base.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface LoginService {
    CommonResult<Map> doLogin(String userName, String passsWord);
    CommonResult<Map> doLoginCode(String code,String id);

}
