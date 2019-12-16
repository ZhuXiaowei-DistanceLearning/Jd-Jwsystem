package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.service.GradeService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/grade")
public class TGradeController extends BaseController {
    @Autowired
    private GradeService gradeService;

    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("/pageQuery")
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) {
        IPage iPage = gradeService.pageQuery(baseQueryParam);
        TableReponse result = TableReponse.of(iPage);
        return result;
    }

    /**
     * ajax列表
     */
    @GetMapping("/listajax")
    public List listajax(BaseQueryParam baseQueryParam){
        return gradeService.listajax(baseQueryParam);
    }
}
