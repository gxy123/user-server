package com.gxy.user.dao;

import com.gxy.user.client.domain.OauthCodeDO;
import com.gxy.user.client.query.OauthCodeQueryDO;
import com.gxy.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java. 更多的细节请参考该类.
只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表.
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-09 18:20:54
 */
@Mapper
public interface OauthCodeDao extends BaseDAO<OauthCodeDO, OauthCodeQueryDO> {

}
