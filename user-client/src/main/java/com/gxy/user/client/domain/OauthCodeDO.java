package com.gxy.user.client.domain;

import com.gxy.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 在项目中,主要操作oauth_code表的对象是JdbcAuthorizationCodeServices.java. 更多的细节请参考该类.
只有当grant_type为"authorization_code"时,该表中才会有数据产生; 其他的grant_type没有使用该表.
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-09 18:20:54
 */
@Data
@ApiModel
public class OauthCodeDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private String code;
            @ApiModelProperty("")
        private byte[] authentication;
    }
