package com.zxw.jwxt.vo;

import lombok.Data;

/**
 * @author zxw
 * @date 2019/11/7 19:28
 */
@Data
public class BaseQueryParam {
    private Integer offset;
    private Integer limit;
    private String sort;
    private String keyword;
}
