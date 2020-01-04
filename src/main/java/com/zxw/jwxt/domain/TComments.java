package com.zxw.jwxt.domain;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxw
 * @since 2020-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TComments对象", description="")
public class TComments implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String teamId;

    private Integer commentType;

    private String commentBatch;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;
}
