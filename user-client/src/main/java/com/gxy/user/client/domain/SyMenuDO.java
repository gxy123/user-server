package com.gxy.user.client.domain;

import com.gxy.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:37
 */
@Data
@ApiModel
public class SyMenuDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Integer id;
            @ApiModelProperty("")
        private Integer menuId;
            @ApiModelProperty("")
        private String menuName;
            @ApiModelProperty("")
        private Integer parentId;
            @ApiModelProperty("")
        private String actionUrl;
    }
