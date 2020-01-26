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
 * @since 2020-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TeacherCourse对象", description="")
public class TeacherCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "学期")
    private String teamId;

    @ApiModelProperty(value = "教师编号")
    private String teacherId;

    @ApiModelProperty(value = "周时")
    private String weekId;

    @ApiModelProperty(value = "课时")
    private String sectionId;

    @ApiModelProperty(value = "是否结课")
    private Integer end;

    @ApiModelProperty(value = "是否可以评论")
    private Integer comment;

    @ApiModelProperty(value = "课程编号")
    private String cid;

    @ApiModelProperty(value = "已选人数")
    private Integer people;

    @ApiModelProperty(value = "总人数")
    private Integer totalPeople;

    @ApiModelProperty(value = "上课教室")
    private String classroom;

    private Integer status;


}
