package com.gxy.user.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


import com.gxy.client.base.CommonResult;
import com.gxy.user.service.SyUserService;
import com.gxy.service.base.BaseControllerImpl;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.domain.SyUserDO;
import com.gxy.user.client.query.SyUserQueryDO;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class SyUserController extends BaseControllerImpl<SyUserDO, SyUserQueryDO> {

    @Autowired
    private SyUserService baseService;

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
    public CommonResult<SyUserDO> detail(@RequestParam("id") Long id) {
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
    public CommonResult<Long> update(@ModelAttribute("pojo") SyUserDO t) {
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

    @ApiOperation(value = "通过用户名查找用户信息", httpMethod = "GET", notes = "通过用户名查找用户信息")
    @RequestMapping("getUser/{username}")
    public CommonResult<SyUserDO> getUserByUserName(@PathVariable("username") String username) {
        CommonResult<SyUserDO> query =baseService.getSyUserDOByUserName(username);
        return query;
    }

}
