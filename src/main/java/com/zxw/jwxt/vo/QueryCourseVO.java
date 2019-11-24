package com.zxw.jwxt.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
