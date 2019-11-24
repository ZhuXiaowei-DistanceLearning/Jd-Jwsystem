package com.zxw.jwxt.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
public class QueryClassesVO extends BaseQueryParam {
    List<String> cIds;
}
