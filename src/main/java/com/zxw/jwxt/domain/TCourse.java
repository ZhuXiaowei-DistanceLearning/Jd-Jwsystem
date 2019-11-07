package com.zxw.jwxt.domain;

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
@ApiModel(value="TCourse对象", description="")
public class TCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Integer credit;

    private String classroom;

    private Integer people;

    private String sectionId;

    private String weekId;

    private String teacherId;

    private String natureId;

    @TableField("totalPeople")
    private Integer totalPeople;

    private String teamId;

    @ApiModelProperty(value = "总学时")
    private Integer totalTime;

    @ApiModelProperty(value = "绩点")
    private Integer point;

    @ApiModelProperty(value = "考核方式")
    private String wayId;

    @ApiModelProperty(value = "课程属性")
    private String cstatusId;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "是否考试")
    @TableField("isExam")
    private Integer isExam;

    @ApiModelProperty(value = "开课学院")
    private String collegeId;


}
