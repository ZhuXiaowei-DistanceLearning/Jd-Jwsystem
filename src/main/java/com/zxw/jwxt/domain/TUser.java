package com.zxw.jwxt.domain;

import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="TUser对象", description="")
public class TUser extends UserRealm implements Serializable{

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private Double salary;

    private LocalDate birthday;

    private String gender;

    private String station;

    private String telephone;

    private String remark;

    private String qx;

    private String sid;


}
