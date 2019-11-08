package com.zxw.common.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxw
 * @date 2019/11/8 21:32
 */
@Data
@NoArgsConstructor
public class TableReponse extends PageUtils {
    private Map<String, Object> map = new HashMap<>();

    public static TableReponse of(PageUtils pageUtils) {
        TableReponse tableReponse = new TableReponse();
        tableReponse.setRows(pageUtils.getRows());
        tableReponse.setTotal(pageUtils.getTotal());
        return tableReponse;

    }

    public TableReponse(Map<String, Object> map) {
        this.map = map;
    }
}
