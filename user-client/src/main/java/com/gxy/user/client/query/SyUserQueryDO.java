package com.gxy.user.client.query;

import com.gxy.client.base.BaseQueryDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
@Data
@ApiModel
public class SyUserQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Integer id;
    @ApiModelProperty("")
    private Integer userId;
    @ApiModelProperty("")
    private String username;
    @ApiModelProperty("")
    private String password;
    @ApiModelProperty("")
    private String phone;
}
