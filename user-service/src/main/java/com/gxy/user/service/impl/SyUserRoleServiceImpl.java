package com.gxy.user.service.impl;

import com.gxy.user.client.domain.SyUserRoleDO;
import com.gxy.user.client.query.SyUserRoleQueryDO;
import com.gxy.user.dao.SyUserRoleDao;
import com.gxy.user.service.SyUserRoleService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SyUserRoleServiceImpl extends BaseServiceAOImpl<SyUserRoleDO, SyUserRoleQueryDO> implements SyUserRoleService {

    @Resource
    private SyUserRoleDao baseDao;


    @Override
    public BaseDAO<SyUserRoleDO, SyUserRoleQueryDO> getDAO() {
        return baseDao;
    }


}
