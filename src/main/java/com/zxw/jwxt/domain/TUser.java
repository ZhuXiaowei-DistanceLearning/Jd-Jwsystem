package com.zxw.jwxt.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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
@ApiModel(value = "TUser对象", description = "")
public class TUser extends UserRealm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private Double salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private String station;

    private String telephone;

    private String remark;

    private String qx;

    private String id;

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setQx(String qx) {
        this.qx = qx;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
