package com.zxw.jwxt.controller;


import com.zxw.common.exception.BadRequestException;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.TScore;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.service.CourseService;
import com.zxw.jwxt.service.ScoreService;
import com.zxw.jwxt.service.StudentService;
import com.zxw.jwxt.vo.QueryScoreVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
@RequestMapping("/api/score")
public class TScoreController extends BaseController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;


    /**
     * 选课实现
     *
     * @param scoreVO
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody QueryScoreVO scoreVO) {
        // 判断是否已经选修
        Boolean b = scoreService.findIsSelect(getUserId(), scoreVO.getCid());
        if (!b) {
            // 判断人数是否已满
            TCourse tCourse = courseService.findById(scoreVO.getCid());
            if (!tCourse.getPeople().equals(tCourse.getTotalPeople())) {
                // 选修
                RS rs = scoreService.save(scoreVO,getUserId());
                RS people = courseService.updatePeople(scoreVO.getCid());
                if (rs.get("status").equals("1")) {
                    return ResponseEntity.ok(rs);
                }
                throw new BadRequestException("选课失败");
            }
            throw new BadRequestException("课程人数已满");
        }
        throw new BadRequestException("已经选择了该门课程,不能重复下载");
    }


    /**
     * session获取addStudentScore
     * addScore
     *
     * @param studentId
     */
    @GetMapping("/findStudent")
    public List<TScore> findStudent(String studentId) throws IOException {
        List<TScore> list = scoreService.queryByStudentId(studentId);
        return list;
    }

    /**
     * @param scoreVO
     * @return
     */
    @PostMapping("/addScore")
    public ResponseEntity addStudentScore(@RequestBody QueryScoreVO scoreVO) {
        RS rs = scoreService.addScore(scoreVO);
        if (rs.get("status").equals("1")) {
            return ResponseEntity.ok(rs);
        }
        throw new BadRequestException("添加成绩失败");
    }

    /**
     * 查找选修的课程
     */
    @GetMapping("/findAllCourseByStudentId")
    public RS findAllCourseByStudentId(QueryScoreVO scoreVO, Model model) {
        Subject subject = SecurityUtils.getSubject();
        TStudent student = (TStudent) subject.getPrincipal();
        List<TScore> list = scoreService.findAllCourseByStudentId(scoreVO.getSid());
//        request.setAttribute("allCourse", list);
        model.addAttribute("allCourse", list);
        return RS.ok();
    }

    /**
     * 调用方法，转发带参数到学生添加缺勤中
     *
     * @return
     */
    @GetMapping("/findStudentScore")
    public List<TScore> findStudentScore(QueryScoreVO scoreVO) {
        Subject subject = SecurityUtils.getSubject();
        TStudent student = (TStudent) subject.getPrincipal();
        List<TScore> list = scoreService.findStudentScore(scoreVO.getSid());
        List<TScore> scores = new ArrayList<>();
        return list;
    }

    /**
     * 跳转到student中
     *
     * @return
     */
    @PostMapping("/addAbsent")
    public ResponseEntity addAbsent(@RequestBody QueryScoreVO queryScoreVO) {
        RS rs = scoreService.addAbsent(queryScoreVO);
        RS absent = studentService.updateAbsent(queryScoreVO.getSid());
        if (rs.get("status").equals("1") && absent.get("status").equals("1")) {
            return ResponseEntity.ok(rs);
        }
        throw new BadRequestException("考勤更新失败");
    }
}
