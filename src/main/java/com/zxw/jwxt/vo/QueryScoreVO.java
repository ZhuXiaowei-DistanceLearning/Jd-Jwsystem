package com.zxw.jwxt.vo;

import lombok.Data;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
public class QueryScoreVO extends BaseQueryParam {
    private String cid;

    private String sid;

    private String tid;
    private Double attendance;
    private Double usually;
    private Double exam;
    private Double point;
}
