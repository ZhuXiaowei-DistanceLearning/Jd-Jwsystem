package com.zxw.jwxt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer credit;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String classroom;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer people;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sectionId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String weekId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String teacherId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String natureId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer totalPeople;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String teamId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer totalTime;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer point;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String wayId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cstatusId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String status;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer isExam;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String collegeId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String wname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sw;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sse;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String csname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String ename;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String collegeName;
    private String teacherName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tid;
}