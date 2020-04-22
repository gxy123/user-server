package com.gxy.user.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.gxy.client.base.CommonResult;
import com.gxy.user.client.domain.SyUserDO;
import com.gxy.user.client.query.SyUserQueryDO;
import com.gxy.user.client.vo.SyUserVO;
import com.gxy.user.dao.SyUserDao;
import com.gxy.user.service.SyUserService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import com.gxy.user.utils.BeanCopierUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SyUserServiceImpl extends BaseServiceAOImpl<SyUserDO, SyUserQueryDO> implements SyUserService {

    @Resource
    private SyUserDao baseDao;


    @Override
    public BaseDAO<SyUserDO, SyUserQueryDO> getDAO() {
        return baseDao;
    }

    public CommonResult<SyUserDO> getSyUserDOByUserName(String userName) {
        log.info("getSyUserDOByUserName{}",userName);
        if (StringUtils.isEmpty(userName)) {
            return CommonResult.successReturn(null);
        }
        SyUserQueryDO queryDO = new SyUserQueryDO();
        queryDO.setUsername(userName);
        try {
            List<SyUserDO> syUserDOS = baseDao.queryList(queryDO);
            if (!CollectionUtils.isEmpty(syUserDOS)) {
                return CommonResult.successReturn(syUserDOS.get(0));
            }
        } catch (Exception e) {
            log.error("getSyUserDOByUserName_error,userName={}", userName);
        }
        return CommonResult.successReturn(null);
    }

    @Override
    public CommonResult<SyUserVO> getSyUserVOByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return CommonResult.successReturn(null);
        }
        SyUserQueryDO queryDO = new SyUserQueryDO();
        queryDO.setUsername(userName);
        try {
            List<SyUserDO> syUserDOS = baseDao.queryList(queryDO);
            if (!CollectionUtils.isEmpty(syUserDOS)) {
                SyUserDO syUserDO = syUserDOS.get(0);
                SyUserVO vo =new SyUserVO();
                BeanCopierUtil.copy(syUserDO,vo);
                return CommonResult.successReturn(vo);

            }
        } catch (Exception e) {
            log.error("getSyUserVOByUserName_error,userName={}", userName);
        }
        return CommonResult.successReturn(null);
    }
}
