package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.exception.BadRequestException;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.StudentDTO;
import com.zxw.jwxt.service.CourseService;
import com.zxw.jwxt.vo.QueryCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listajax")
    public ResponseEntity listajax(QueryCourseVO courseVO) {
        List list = courseService.listajax(courseVO);
        return ResponseEntity.ok(list);
    }

    /**
     * 添加选课
     *
     * @param courseVO
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody TCourse courseVO) {
        RS rs = courseService.add(courseVO);
        if (rs.get("status").equals("1")) {
            return ResponseEntity.ok(rs);
        }
        throw new BadRequestException("添加失败");
    }

    /**
     * 查找教师的课程
     *
     * @param courseVO
     * @return
     */
    @GetMapping("/findCourseByteacherId")
    public TableReponse findCourseByteacherId(QueryCourseVO courseVO) {
        UserRealm realm = getRealm();
        IPage result = courseService.findCourseByteacherId(courseVO, realm.getId());
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    /**
     * 查询某门课程下的学生
     *
     * @param courseVO
     * @return
     */
    @GetMapping("/findStudentByCourseId")
    public ResponseEntity findStudentByCourseId(QueryCourseVO courseVO) {
        IPage<StudentDTO> result = courseService.findStudentByCourseId(courseVO);
        TableReponse reponse = TableReponse.of(result);
        return ResponseEntity.ok(reponse);
    }

}
