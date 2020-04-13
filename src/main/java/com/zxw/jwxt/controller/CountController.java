package com.zxw.jwxt.controller;

import com.zxw.jwxt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxw
 * @date 2019/12/18 20:22
 */
@RestController
@RequestMapping("/api/count")
public class CountController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ITeacherCourseService teacherCourseService;

    /**
     * 统计课程成绩
     *
     * @param cid
     * @return
     */
    @GetMapping("/countCourseScore")
    public ResponseEntity countCourseScore(String cid) {
        List list = new ArrayList();
        Integer no = teacherCourseService.countCourseScore(0, 69, cid);
        Integer six = teacherCourseService.countCourseScore(60, 69, cid);
        Integer seven = teacherCourseService.countCourseScore(70, 79, cid);
        Integer eight = teacherCourseService.countCourseScore(80, 89, cid);
        Integer night = teacherCourseService.countCourseScore(90, 100, cid);
        list.add(no);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(night);
        return ResponseEntity.ok(list);
    }
}
