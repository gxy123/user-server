package com.gxy.user.service;

import com.gxy.client.base.CommonResult;
import com.gxy.user.client.domain.SyUserDO;
import com.gxy.user.client.query.SyUserQueryDO;
import com.gxy.service.base.BaseServiceAO;
import com.gxy.user.client.vo.SyUserVO;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
public interface SyUserService extends BaseServiceAO<SyUserDO, SyUserQueryDO> {
    CommonResult<SyUserDO> getSyUserDOByUserName(String userName);
    CommonResult<SyUserVO> getSyUserVOByUserName(String userName);
}
