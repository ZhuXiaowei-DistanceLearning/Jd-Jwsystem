package com.zxw.jwxt.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxw
 * @since 2020-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Absent对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class Absent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String cid;

    private String sid;

    private String tid;

    private LocalDate createTime;

    @TableField("sectionId")
    private String sectionId;

    private Integer status;

    private String description;


}
