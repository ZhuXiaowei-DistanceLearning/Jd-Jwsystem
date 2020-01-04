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
    private String cid;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sid;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String cname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nname;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer exam;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer score;
}
