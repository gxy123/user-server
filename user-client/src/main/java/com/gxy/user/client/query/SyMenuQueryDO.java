package com.gxy.user.client.query;

import java.io.Serializable;
import java.util.Date;

import com.gxy.client.base.BaseQueryDO;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-04-11 21:39:37
 */
@Data
@ApiModel
public class SyMenuQueryDO extends BaseQueryDO implements Serializable {
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
