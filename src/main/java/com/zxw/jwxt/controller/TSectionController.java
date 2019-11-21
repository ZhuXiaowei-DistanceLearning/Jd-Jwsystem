package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.service.SectionService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.zxw.jwxt.controller.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/section")
public class TSectionController extends BaseController {
    @Autowired
    private SectionService sectionService;

    /**
     * 分页查询
     * @return
     */
    @GetMapping("/pageQuery")
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) {
        IPage iPage = sectionService.pageQuery(baseQueryParam);
        TableReponse result = TableReponse.of(iPage);
        return result;
    }
}
