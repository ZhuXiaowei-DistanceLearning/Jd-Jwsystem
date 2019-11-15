package com.zxw.common.pojo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxw
 * @date 2019/11/8 21:32
 */
@Data
@AllArgsConstructor
public class TableReponse extends Page {
    private Map<String, Object> extraData = new HashMap<>();
    private long realTotal;

    public static TableReponse of(IPage page) {
        TableReponse tableReponse = new TableReponse(page);
        tableReponse.setRealTotal(page.getTotal());
        return tableReponse;

    }

    public TableReponse(IPage page) {
        this.setRecords(page.getRecords());
        this.setTotal(page.getTotal());
        this.setCurrent(page.getCurrent());
        this.setSize(page.getSize());
        this.setPages(page.getPages());
    }

    public TableReponse(Map<String, Object> map) {
        this.extraData = map;
    }
}
