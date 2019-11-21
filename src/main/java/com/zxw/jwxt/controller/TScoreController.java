package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.TScore;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.service.CourseService;
import com.zxw.jwxt.service.ScoreService;
import com.zxw.jwxt.vo.QueryScoreVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zxw.jwxt.controller.BaseController;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/score")
public class TScoreController extends BaseController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private CourseService courseService;

    /**
     * 选课实现
     *
     * @param scoreVO
     * @return
     */
    @PostMapping("/save")
    public RS save(QueryScoreVO scoreVO) {
        UserRealm realm = getRealm();
//        Subject subject = SecurityUtils.getSubject();
//        TStudent student = (TStudent) subject.getPrincipal();
        TScore score = new TScore();
        score.setStudentId(realm.getId());
        score.setCourseId(scoreVO.getCourseId());
        scoreService.saveCourse(score);
        int i = scoreVO.getPeople() + 1;
        courseService.addPeople(i, score);
        return RS.ok();

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
     * 获取平和期
     * 设置最终
     * 保存
     *
     * @throws IOException
     */
    @GetMapping("/findTeacherCourseStudent")
    public TableReponse findTeacherCourseStudent(QueryScoreVO scoreVO) {
//        TCourse course = (TCourse) session.getAttribute("addStudentScore");
        IPage result = scoreService.addScore(scoreVO);
        TableReponse reponse = TableReponse.of(result);
        return reponse;
    }

    /**
     * @param scoreVO
     * @return
     */
    @PostMapping("/addStudentScore")
    public RS addStudentScore(QueryScoreVO scoreVO) {
        String peaceTime = scoreVO.getPeaceTime();
        String endTime = scoreVO.getEndTime();
        if (peaceTime.equals("A+") && endTime.equals("A+")) {
            scoreVO.setScore("A+");
        } else if (peaceTime.equals("A") && endTime.equals("A")) {
            scoreVO.setScore("A");
        } else if (peaceTime.equals("B+") && endTime.equals("B+")) {
            scoreVO.setScore("B+");
        } else if (peaceTime.equals("B") && endTime.equals("B")) {
            scoreVO.setScore("B");
        } else if (peaceTime.equals("C+") && endTime.equals("C+")) {
            scoreVO.setScore("C+");
        } else if (peaceTime.equals("C") && endTime.equals("C")) {
            scoreVO.setScore("C");
        } else if (peaceTime.equals("D+") && endTime.equals("D+")) {
            scoreVO.setScore("D");
        } else if (peaceTime.equals("D") && endTime.equals("D")) {
            scoreVO.setScore("D");
        } else if (peaceTime.equals("F") && endTime.equals("F")) {
            scoreVO.setScore("F");
        } else if (peaceTime.equals("F") && endTime.equals("A")) {
            scoreVO.setScore("F");
        }
        return scoreService.saveCourse(null);
    }

    /**
     * @param scoreVO
     * @return
     * @throws IOException
     */
    @GetMapping("/findIdExist")
    public RS findIdExist(QueryScoreVO scoreVO) throws IOException {
        TStudent student = (TStudent) SecurityUtils.getSubject().getPrincipal();
        String flag = "0";
//        List<TScore> exit = scoreService.findStudentExit(student.getSid(), ids);
        return null;
    }

    /**
     * 转发到学生中的日期英语
     */
    @GetMapping("/findAllCourseByStudentId")
    public RS findAllCourseByStudentId(QueryScoreVO scoreVO, Model model) {
        Subject subject = SecurityUtils.getSubject();
        TStudent student = (TStudent) subject.getPrincipal();
        List<TScore> list = scoreService.findAllCourseByStudentId(scoreVO.getStudentId());
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
        List<TScore> list = scoreService.findStudentScore(scoreVO.getStudentId());
        List<TScore> scores = new ArrayList<>();
        return list;
    }

    /**
     * 跳转到student中
     *
     * @return
     */
    @GetMapping("/addAbsent")
    public String addAbsent(String[] lateStudentId, String cid) {
//        scoreService.addAbsent(lateStudentId, cid);
        return "forward:/student/addStudentAbsent.action?lateStudentId=" + lateStudentId;
    }
}
