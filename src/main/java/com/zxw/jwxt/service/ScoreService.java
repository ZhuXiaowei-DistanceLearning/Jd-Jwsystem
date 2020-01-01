package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TScore;
import com.zxw.jwxt.mapper.TScoreMapper;
import com.zxw.jwxt.vo.QueryScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class ScoreService extends BaseService {
    @Autowired
    private TScoreMapper scoreMapper;

    public RS saveCourse(QueryScoreVO model) {
//        return scoreMapper.insert(model) == 0 ? RS.error("插入失败") : RS.ok();
        return null;
    }

    /**
     * @param id
     * @return
     */
    public List<TScore> queryByStudentId(String id) {
        List<TScore> list = scoreMapper.findStudentId(id);
        return list;
    }

    /**
     * 查找学生的所有课程信息
     *
     * @param sid
     * @return
     */
    public List<TScore> findAllCourseByStudentId(String sid) {
        List<TScore> list = scoreMapper.findAllCourseByStudentId(sid);
        return list;
    }

    public RS addScore(QueryScoreVO scoreVO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("student_id", scoreVO.getSid());
        queryWrapper.eq("course_id", scoreVO.getCid());
        TScore tScore = scoreMapper.selectOne(queryWrapper);
        Double attendance = scoreVO.getAttendance() * 0.2;
        Double usually = scoreVO.getUsually() * 0.2;
        Double exam = scoreVO.getExam() * 0.6;
        tScore.setAttendance(scoreVO.getAttendance().intValue());
        tScore.setUsually(scoreVO.getUsually().intValue());
        tScore.setExam(scoreVO.getExam().intValue());
        tScore.setScore(attendance.intValue() + usually.intValue() + exam.intValue());
        int i = scoreMapper.update(tScore, queryWrapper);
        return i == 0 ? RS.error("操作失败") : RS.ok();
    }

    /**
     * 查找选修了该门课程的学生
     *
     * @param sid
     * @param ids
     * @return
     */
    public List<TScore> findStudentExit(String sid, String ids) {
        List<TScore> list = scoreMapper.findCourseStudentId(sid, ids);
        return list;
    }

    /**
     * 查询学生成绩
     *
     * @param sid
     * @return
     */
    public List<TScore> findStudentScore(String sid) {
        List<TScore> list = scoreMapper.findStudentScore(sid);
        return list;
    }

    /**
     * 记录缺勤
     *
     * @param scoreVO
     * @return
     */
    public RS addAbsent(QueryScoreVO scoreVO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("course_id", scoreVO.getCid());
        queryWrapper.eq("student_id", scoreVO.getSid());
        TScore tScore = scoreMapper.selectOne(queryWrapper);
        tScore.setAbsent(tScore.getAbsent() + 1);
        int i = scoreMapper.update(tScore, queryWrapper);
        return i == 1 ? RS.ok() : RS.error("添加缺勤失败");
    }
}
