package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TSpecialty;
import com.zxw.jwxt.service.SpecialtyService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/specialty")
public class TSpecialtyController extends BaseController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("redoSpecialty")
    public RS redoSpecialty(String id) {
        RS rs = specialtyService.redoSpecialty(id);
        return rs;
    }

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) throws IOException {
        IPage result = specialtyService.pageQuery(baseQueryParam);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    @PostMapping("/addSpecialty")
    public RS saveOrUpdateSpeciatly(TSpecialty specialty) {
        RS rs = specialtyService.saveOrUpdateSpeciatly(specialty);
        return rs;
    }

    @PostMapping("/updateSpecialty")
    public RS updateSpecialty(TSpecialty specialty) {
        RS rs = specialtyService.update(specialty);
        return rs;
    }

    @GetMapping("/delete")
    public RS delete(String id) {
        RS rs = specialtyService.deleteBatch(id);
        return rs;
    }
}
