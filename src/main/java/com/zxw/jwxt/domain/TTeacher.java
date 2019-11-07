package com.zxw.jwxt.domain;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="TTeacher对象", description="")
public class TTeacher extends UserRealm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师编号")
    private String tid;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "姓名")
    private String tname;

    @ApiModelProperty(value = "性别")
    private String tsex;

    @ApiModelProperty(value = "年龄")
    private String tage;

    @ApiModelProperty(value = "状态：0表示在职，1表示辞职，2表示离职")
    private String status;

    @ApiModelProperty(value = "所属院系")
    private String collegeId;

    @ApiModelProperty(value = "权限")
    private String qx;

    @ApiModelProperty(value = "工作日期")
    @TableField("beginTime")
    private LocalDateTime beginTime;

    @ApiModelProperty(value = "薪水")
    private Double salary;

    @ApiModelProperty(value = "政治面貌")
    @TableField("politicalStatus")
    private String politicalStatus;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "身份证号")
    private String idcard;


}
