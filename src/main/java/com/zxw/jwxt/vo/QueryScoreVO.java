package com.zxw.jwxt.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryScoreVO extends BaseQueryParam {
    private List<String> idList;
    private String courseId;

    private String studentId;

    private String teacherId;

    private String peaceTime;

    private String endTime;

    private String score;

    private String absent;

    private Integer people;
}
