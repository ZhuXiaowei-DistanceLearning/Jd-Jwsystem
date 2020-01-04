package com.zxw.jwxt.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zxw
 * @date 2020/1/3 21:50
 */
@Data
public class ScoreDTO {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String csname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String score;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String tname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer isExam;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer credit;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer totalTime;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer point;
}
