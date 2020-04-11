package com.gxy.user.web.api;

import com.google.gson.JsonObject;
import com.gxy.client.base.CommonResult;
import com.gxy.service.base.BaseControllerImpl;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.domain.OauthCodeDO;
import com.gxy.user.client.query.OauthCodeQueryDO;
import com.gxy.user.service.OauthCodeService;
import com.gxy.user.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java. 更多的细节请参考该类.
 * 只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表.
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-09 18:20:54
 */
@Api
@Slf4j
@RestController
@RequestMapping("/api/user")
public class OauthCodeApi extends BaseControllerImpl<OauthCodeDO, OauthCodeQueryDO> {

    @Autowired
    private OauthCodeService baseService;
    @Autowired
    private TokenService tokenservice;

    @Override
    public BaseServiceAO<OauthCodeDO, OauthCodeQueryDO> getService() {
        return baseService;
    }

    @ApiOperation(value = "登录", httpMethod = "POST", notes = "登录逻辑")
    @PostMapping("doLogin")
    public CommonResult<Map> getToken(@RequestParam String username, @RequestParam String pwd) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", Optional.ofNullable(pwd).orElse("111111"));
        map.add("grant_type", "password");
        map.add("scope", "all");
        //LinkedHashMap<String,String> token = (LinkedHashMap<String, String>)serviceAuthFeign.generateToken(map);

        Map map1 = tokenservice.doLogin(map);
        return CommonResult.successReturn(map1);
    }

    /**
     * 通用查询逻辑
     *
     * @param userId 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("/user/{userId}")
    public CommonResult<OauthCodeDO> select(@PathVariable("userId") Long userId) {
        CommonResult<OauthCodeDO> oauthCodeDOCommonResult = getService().get(userId);
        return oauthCodeDOCommonResult;
    }

    /**
     * 获取详情
     *
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<OauthCodeDO> detail(@RequestParam("id") Long id) {
        return getService().get(id);
    }

    /**
     * 通用更新逻辑
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "GET", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Long> update(@ModelAttribute("pojo") OauthCodeDO t) {
        return getService().modify(t);
    }

    /**
     * 通用删除逻辑
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Long> delete(@RequestParam("id") Long id) {
        return getService().remove(id);
    }

    /**
     * 通用插入逻辑
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("add")
    public CommonResult<OauthCodeDO> insert(@RequestBody OauthCodeDO t) {
        return getService().save(t);
    }
}
