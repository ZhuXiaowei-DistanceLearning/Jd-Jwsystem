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
@ApiModel(value="TScore对象", description="")
public class TScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private String courseId;

    private String studentId;

    private String teacherId;

    @TableField("peaceTime")
    private String peaceTime;

    @TableField("endTime")
    private String endTime;

    private String score;

    private String absent;


}
