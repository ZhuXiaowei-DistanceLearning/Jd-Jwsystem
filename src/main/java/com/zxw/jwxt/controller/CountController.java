package com.zxw.jwxt.controller;

import com.zxw.jwxt.service.ScoreService;
import com.zxw.jwxt.service.StudentService;
import com.zxw.jwxt.service.TeacherService;
import com.zxw.jwxt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxw
 * @date 2019/12/18 20:22
 */
@RestController
@RequestMapping("/count")
public class CountController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScoreService scoreService;
}
