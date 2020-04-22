package com.gxy.user.service.impl;

import com.gxy.user.client.domain.SyMenuDO;
import com.gxy.user.client.query.SyMenuQueryDO;
import com.gxy.user.dao.SyMenuDao;
import com.gxy.user.service.SyMenuService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SyMenuServiceImpl extends BaseServiceAOImpl<SyMenuDO, SyMenuQueryDO> implements SyMenuService {

    @Resource
    private SyMenuDao baseDao;


    @Override
    public BaseDAO<SyMenuDO, SyMenuQueryDO> getDAO() {
        return baseDao;
    }


}
