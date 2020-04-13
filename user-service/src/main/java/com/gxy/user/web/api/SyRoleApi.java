package com.gxy.user.web.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


import com.gxy.client.base.CommonResult;
import com.gxy.user.service.SyRoleService;
import com.gxy.service.base.BaseControllerImpl;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.domain.SyRoleDO;
import com.gxy.user.client.query.SyRoleQueryDO;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
@Api(description = "-相关接口")
@Slf4j
@RestController
@RequestMapping("/api/syrole")
public class SyRoleApi extends BaseControllerImpl<SyRoleDO, SyRoleQueryDO> {

    @Autowired
    private SyRoleService baseService;

    @Override
    public BaseServiceAO<SyRoleDO, SyRoleQueryDO> getService() {
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
    public CommonResult<List<SyRoleDO>> select(@ModelAttribute("pojo") SyRoleQueryDO q) {
        CommonResult<List<SyRoleDO>> query = getService().query(q);
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
    public CommonResult<SyRoleDO> detail(@RequestParam("id") Long id) {
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
    public CommonResult<Long> update(@ModelAttribute("pojo") SyRoleDO t) {
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
    public CommonResult<SyRoleDO> insert(@RequestBody SyRoleDO t) {
        return getService().save(t);
    }
}
