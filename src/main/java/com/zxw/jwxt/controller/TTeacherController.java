package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TTeacher;
import com.zxw.jwxt.service.TeacherService;
import com.zxw.jwxt.vo.QueryCourseVO;
import com.zxw.jwxt.vo.QueryTeacherVO;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zxw.jwxt.controller.BaseController;

import java.io.IOException;
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
@RequestMapping("/api/teacher")
public class TTeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 分页查询
     *
     * @param teacherVO
     * @return
     */
    @GetMapping("/pageQuery")
    public TableReponse pageQuery(QueryTeacherVO teacherVO) {
        IPage result = teacherService.pageQuery(teacherVO);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    @GetMapping("/teacherByCollege")
    public List<TTeacher> teacherByCollege(String id) {
        List<TTeacher> list = teacherService.findListNoStatusAndCollege(id);
        return list;
    }

    /**
     * 添加用户
     */
    @PostMapping("/add")
    public RS add(TTeacher teacher, String roleIds) {
        RS rs = teacherService.save(teacher, roleIds);
        return rs;
    }

    @GetMapping("/findInfo")
    public ResponseEntity findInfo(String tid) {
        TTeacher teacher = teacherService.findInfo(getUserId());
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/findSchedule")
    public ResponseEntity findSchedule(QueryCourseVO queryCourseVO){
        List list = teacherService.findSchedule(queryCourseVO,getUserId());
        return ResponseEntity.ok(list);
    }
}
