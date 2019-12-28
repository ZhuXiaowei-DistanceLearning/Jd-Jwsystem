package com.zxw.jwxt.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zxw.jwxt.domain.TClasses;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
public class QueryStudentVO extends BaseQueryParam {
    List<String> studentIds;
    String id;
    // 课程id
    private String cid;
    // 成绩id
    private String sid;
    private String password;
    private String sname;
    private String sex;
    private String scity;
    private String qx;
    private Integer absent;
    private String classesId;
    private String gradeId;
    private Date beginTime;
    private Date endTime;
    private String phone;
    private String idcard;
    private String address;
    private String politicalStatus;
    private String classname;
}
