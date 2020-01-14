package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.exception.BadRequestException;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.TScore;
import com.zxw.jwxt.dto.CourseDTO;
import com.zxw.jwxt.service.CourseService;
import com.zxw.jwxt.service.ScoreService;
import com.zxw.jwxt.service.StudentService;
import com.zxw.jwxt.vo.QueryScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                RS rs = scoreService.save(scoreVO, getUserId());
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
     * 查找学生
     *
     * @param studentId
     */
    @GetMapping("/findStudent")
    public List<TScore> findStudent(String studentId) throws IOException {
        List<TScore> list = scoreService.queryByStudentId(studentId);
        return list;
    }

    /**
     * 添加成绩
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
    @GetMapping("/findSelectCourseByStudentId")
    public ResponseEntity findSelectCourseByStudentId(QueryScoreVO scoreVO) {
        List<CourseDTO> list = scoreService.findSelectCourseByStudentId(getUserId());
        return ResponseEntity.ok(list);
    }

    /**
     * 查询学生成绩
     *
     * @return
     */
    @GetMapping("/findStudentScore")
    public IPage findStudentScore(QueryScoreVO scoreVO) {
        IPage list = scoreService.findStudentScore(scoreVO,getUserId());
        return list;
    }

    /**
     * 添加缺勤
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

    /**
     * 选课退选
     *
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity delete(QueryScoreVO scoreVO) {
        RS rs = scoreService.delete(getUserId(), scoreVO.getCid());
        if (rs.get("status").equals("1")) {
            RS delete = courseService.deletePeople(scoreVO.getCid());
            return ResponseEntity.ok(rs);
        }
        throw new BadRequestException("退选失败");
    }
}
