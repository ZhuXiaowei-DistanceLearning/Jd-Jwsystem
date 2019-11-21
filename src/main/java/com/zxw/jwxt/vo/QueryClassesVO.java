package com.zxw.jwxt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zxw
 * @date 2019/11/21 13:51:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryClassesVO extends BaseQueryParam {
    List<String> cIds;
}
