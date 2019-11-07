package com.zxw.jwxt.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RoleFunction对象", description="")
public class RoleFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private String functionId;


}
