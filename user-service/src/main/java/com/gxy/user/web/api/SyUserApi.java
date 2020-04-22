package com.gxy.user.web.api;

import com.gxy.annotation.NeedLogin;
import com.gxy.client.base.CommonResult;
import com.gxy.client.base.SessionUserVO;
import com.gxy.client.base.SessionUtils;
import com.gxy.service.base.BaseControllerImpl;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.domain.SyUserDO;
import com.gxy.user.client.query.SyUserQueryDO;
import com.gxy.user.service.LoginService;
import com.gxy.user.service.SyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
@Api(description = "-相关接口")
@Slf4j
@RestController
@RequestMapping("/api/syuser")
public class SyUserApi extends BaseControllerImpl<SyUserDO, SyUserQueryDO> {

    @Autowired
    SyUserService baseService;
    @Autowired
    LoginService loginService;

    @Override
    public BaseServiceAO<SyUserDO, SyUserQueryDO> getService() {
        return baseService;
    }

    /**
     * 通用查询逻辑
     *
     * @param q 查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("query")
    public CommonResult<List<SyUserDO>> select(@ModelAttribute("pojo") SyUserQueryDO q) {
        CommonResult<List<SyUserDO>> query = getService().query(q);
        CommonResult<Integer> count = getService().count(q);
        query.setTotal(count.getResult());
        return query;
    }

    /**
     * 获取详情
     *
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    @NeedLogin
    public CommonResult<SyUserDO> detail(@RequestParam("id") Long id) {
        log.info("sdfsdf={}",SessionUtils.getUserInfo().getUserId());
        return getService().get(id);
    }

    /**
     * 通用更新逻辑
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Long> update(@RequestBody SyUserDO t) {
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
    public CommonResult<SyUserDO> insert(@RequestBody SyUserDO t) {
        return getService().save(t);
    }

    @ApiOperation(value = "登录接口", httpMethod = "POST", notes = "登录接口")
    @RequestMapping("login")
    public CommonResult<Map> login(@RequestBody SyUserDO syUserDO) {
        CommonResult<Map> mapCommonResult = loginService.doLogin(syUserDO.getUsername(), syUserDO.getPassword());
        return mapCommonResult;
    }
    @ApiOperation(value = "接受授权码接口", httpMethod = "GET", notes = "接受授权码接口")
    @RequestMapping("receiveCode")
    public CommonResult<Map> receiveCode(@RequestParam("code") String code,@RequestParam("id")String id) {
        CommonResult<Map> mapCommonResult = loginService.doLoginCode(code,id);
        return mapCommonResult;
    }
}
