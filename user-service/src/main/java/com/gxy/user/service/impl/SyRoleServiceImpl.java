package com.gxy.user.service.impl;

import com.gxy.user.client.domain.SyRoleDO;
import com.gxy.user.client.query.SyRoleQueryDO;
import com.gxy.user.dao.SyRoleDao;
import com.gxy.user.service.SyRoleService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SyRoleServiceImpl extends BaseServiceAOImpl<SyRoleDO, SyRoleQueryDO> implements SyRoleService {

    @Resource
    private SyRoleDao baseDao;


    @Override
    public BaseDAO<SyRoleDO, SyRoleQueryDO> getDAO() {
        return baseDao;
    }


}
