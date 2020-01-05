package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.service.PlanCourseService;
import com.zxw.jwxt.vo.QueryPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxw
 * @since 2020-01-05
 */
@RestController
@RequestMapping("/api/planCourse")
public class PlanCourseController extends BaseController {

    @Autowired
    private PlanCourseService planCourseService;

    @GetMapping("/pageQuery")
    public ResponseEntity pageQuery(QueryPlanVO planVO){
        IPage iPage = planCourseService.pageQuery(planVO);
        return ResponseEntity.ok(iPage);
    }

}
