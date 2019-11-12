package com.zxw.common.pojo;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class TableReponse extends Page {
    private Map<String, Object> extraData = new HashMap<>();
    private long realTotal;

    public static TableReponse of(IPage page) {
        TableReponse tableReponse = new TableReponse();
        tableReponse.setRealTotal(page.getTotal());
        return tableReponse;

    }

    public TableReponse(Map<String, Object> map) {
        this.extraData = map;
    }
}
