package com.gxy.user.client.vo;

import com.gxy.user.client.domain.SyMenuDO;
import com.gxy.user.client.domain.SyRoleDO;
import com.gxy.user.client.domain.SyUserDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SyUserVO extends SyUserDO {
    @ApiModelProperty("拥有角色")
    List<SyRoleDO> roleDOS;
    @ApiModelProperty("拥有权限")
    List<SyMenuDO> menuDOS;

}
