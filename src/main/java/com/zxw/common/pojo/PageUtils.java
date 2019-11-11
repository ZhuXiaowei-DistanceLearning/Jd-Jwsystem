package com.zxw.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils implements Serializable {

    private long total;
    private List<?> rows;
    private Map<String, Object> extraData = new HashMap<>();
    private long realTotal;

}
