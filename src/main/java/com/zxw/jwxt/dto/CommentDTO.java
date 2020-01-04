package com.zxw.jwxt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @PACKAGE_NAME: com.zxw.jwxt.dto
 * @author: zxw
 * @DATE: 2020/1/4 18:32:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer commentType;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String commentBatch;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endTime;
}
