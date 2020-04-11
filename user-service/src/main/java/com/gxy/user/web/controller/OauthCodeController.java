package com.gxy.user.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import   com.gxy.client.base.CommonResult;
import   com.gxy.user.service.OauthCodeService;
import   com.gxy.service.base.BaseControllerImpl;
import   com.gxy.service.base.BaseServiceAO;
import   com.gxy.user.client.domain.OauthCodeDO;
import   com.gxy.user.client.query.OauthCodeQueryDO;

/**
 * 在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java. 更多的细节请参考该类.
只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表.
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-09 18:20:54
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class OauthCodeController extends BaseControllerImpl<OauthCodeDO, OauthCodeQueryDO> {

    @Autowired
    private OauthCodeService baseService;

    @Override
    public BaseServiceAO<OauthCodeDO, OauthCodeQueryDO> getService() {
        return baseService;
    }

    /**
     * 用户名查询
     *
     * @param username        查询对象
     * @return
     */
    @ApiOperation(value = "用户名查询", httpMethod = "GET", notes = "用户名查询")
    @RequestMapping("${username}")
    public CommonResult<List<OauthCodeDO>> select(@PathVariable("username") String username) {
        return CommonResult.successReturn(null);
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
