package com.gxy.user.service.impl;

import com.gxy.user.client.domain.OauthCodeDO;
import com.gxy.user.client.query.OauthCodeQueryDO;
import com.gxy.user.dao.OauthCodeDao;
import com.gxy.user.service.OauthCodeService;
import com.gxy.service.base.BaseDAO;
import com.gxy.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OauthCodeServiceImpl extends BaseServiceAOImpl<OauthCodeDO, OauthCodeQueryDO> implements OauthCodeService {

    @Resource
    private OauthCodeDao baseDao;


    @Override
    public BaseDAO<OauthCodeDO, OauthCodeQueryDO> getDAO() {
        return baseDao;
    }


}
