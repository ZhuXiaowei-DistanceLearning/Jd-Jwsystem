package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.TTeacher;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.service.CourseService;
import com.zxw.jwxt.vo.QueryCourseVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zxw.jwxt.controller.BaseController;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/api/course")
public class TCourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/pageQuery")
    public TableReponse pageQuery(QueryCourseVO courseVO) {
        IPage result = courseService.pageQuery(courseVO);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    /**
     * @param courseVO
     * @return
     */
    @PostMapping("/add")
    public RS add(TCourse courseVO) {
        return courseService.add(courseVO);
    }

    @GetMapping("/findCourseByteacherId")
    public TableReponse findCourseByteacherId(QueryCourseVO courseVO) {
        UserRealm realm = getRealm();
        IPage result = courseService.findCourseByteacherId(courseVO, realm.getId());
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    @RequestMapping("/addScorePage")
    public TableReponse addScorePage(QueryCourseVO courseVO) {
        TCourse course = courseService.findById(courseVO.getId());
        return null;
    }
}
