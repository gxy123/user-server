package com.gxy.user.client.query;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.gxy.client.base.BaseQueryDO;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:38
 */
@Data
@ApiModel
public class SyRoleMenuQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

                    @ApiModelProperty("")
            private Integer id;
                    @ApiModelProperty("")
            private Integer roleMenuId;
                    @ApiModelProperty("")
            private Integer roleId;
                    @ApiModelProperty("")
            private Integer menuId;
    }
