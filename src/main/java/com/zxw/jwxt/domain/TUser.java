package com.zxw.jwxt.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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

    private String qx;

    private String id;

    private String status;
    @TableField(value = "collegeId")
    private String collegeId;

    @Override
    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

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
