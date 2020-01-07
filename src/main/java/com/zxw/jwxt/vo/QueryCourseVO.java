package com.zxw.jwxt.vo;

import lombok.Data;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
public class QueryCourseVO extends BaseQueryParam {
    private String id;

    private String name;

    private Integer credit;

    private String classroom;

    private String sectionId;

    private String weekId;

    private String teacherId;

    private String natureId;

    private String teamId;

    private String wayId;

    private String cstatusId;

    private String status;

    private Integer isExam;

    private String collegeId;
    private String systemId;
    private String endStatus;
}
