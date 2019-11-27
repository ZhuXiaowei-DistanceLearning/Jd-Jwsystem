package com.zxw.jwxt.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
public class QueryClassesVO extends BaseQueryParam {

    private List<String> cIds;

    private String id;

    private String classname;

    private String specialtyId;

    private String collegeId;

    private Integer people;

    private String gradeId;

    private LocalDate year;

    // 院系名称
    private String cname;

    // 专业名称
    private String sname;
}
