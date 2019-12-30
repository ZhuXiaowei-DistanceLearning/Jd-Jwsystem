package com.zxw.jwxt.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PACKAGE_NAME: com.zxw.jwxt.dto
 * @author: Administrator
 * @DATE: 2019/12/30 11:36:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private String id;
    private String name;
    private Integer credit;
    private String classroom;
    private Integer people;
    private String sectionId;
    private String weekId;
    private String teacherId;
    private String natureId;
    private Integer totalPeople;
    private String teamId;
    private Integer totalTime;
    private Integer point;
    private String wayId;
    private String cstatusId;
    private String status;
    private Integer isExam;
    private String collegeId;
    private String wname;
    private String nname;
    private String sw;
    private String sse;
    private String csname;
    private String ename;
    private String tname;
    private String collegeName;
}
