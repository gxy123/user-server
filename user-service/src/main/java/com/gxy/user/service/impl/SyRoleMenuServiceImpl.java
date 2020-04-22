package com.gxy.user.service.impl;

import com.gxy.user.client.domain.SyRoleMenuDO;
import com.gxy.user.client.query.SyRoleMenuQueryDO;
import com.gxy.user.dao.SyRoleMenuDao;
import com.gxy.user.service.SyRoleMenuService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SyRoleMenuServiceImpl extends BaseServiceAOImpl<SyRoleMenuDO, SyRoleMenuQueryDO> implements SyRoleMenuService {

    @Resource
    private SyRoleMenuDao baseDao;


    @Override
    public BaseDAO<SyRoleMenuDO, SyRoleMenuQueryDO> getDAO() {
        return baseDao;
    }


}
