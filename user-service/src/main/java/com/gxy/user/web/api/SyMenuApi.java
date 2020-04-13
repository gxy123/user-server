package com.gxy.user.web.api;

import com.gxy.client.base.CommonResult;
import com.gxy.service.base.BaseControllerImpl;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.domain.SyMenuDO;
import com.gxy.user.client.query.SyMenuQueryDO;
import com.gxy.user.service.SyMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:37
 */
@Api
@Slf4j
@RestController
@RequestMapping("/api/symenu")
public class SyMenuApi extends BaseControllerImpl<SyMenuDO, SyMenuQueryDO> {

    @Autowired
    private SyMenuService baseService;

    @Override
    public BaseServiceAO<SyMenuDO, SyMenuQueryDO> getService() {
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
    public CommonResult<List<SyMenuDO>> select(@ModelAttribute("pojo") SyMenuQueryDO q) {
        CommonResult<List<SyMenuDO>> query = getService().query(q);
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
    public CommonResult<SyMenuDO> detail(@RequestParam("id") Long id) {
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
    public CommonResult<Long> update(@ModelAttribute("pojo") SyMenuDO t) {
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
    public CommonResult<SyMenuDO> insert(@RequestBody SyMenuDO t) {
        return getService().save(t);
    }
}
