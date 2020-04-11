package com.gxy.user.service;

import com.gxy.client.base.CommonResult;
import com.gxy.user.configer.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Service
@FeignClient(name = "auth-api",configuration= FeignConfiguration.class)
public interface TokenService {
    @RequestMapping(method = RequestMethod.POST, value = "/oauth/token")
    Map doLogin(@RequestBody MultiValueMap<String, String> map);

}
