package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TScore;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.mapper.TScoreMapper;
import com.zxw.jwxt.vo.QueryScoreVO;
import com.zxw.jwxt.vo.QueryStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public RS saveCourse(TScore model) {
        return scoreMapper.insert(model) == 0 ? RS.error("插入失败") : RS.ok();
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

    public IPage addScore(QueryScoreVO scoreVO) {
        Page page = getPage(scoreVO);
        IPage iPage = scoreMapper.addStudentScore(page, scoreVO.getCourseId());
        return iPage;
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
     * 添加缺席
     *
     * @param scoreVO
     */
    public void addAbsent(QueryScoreVO scoreVO) {
        TScore record = new TScore();
        record.setCourseId(scoreVO.getCourseId());
        for (String studentId : scoreVO.getIdList()) {
            record.setStudentId(studentId);
            TScore score = scoreMapper.selectById(record);
            String absent = score.getAbsent();
            int times = Integer.valueOf(absent) + 1;
            score.setAbsent(String.valueOf(times));
            scoreMapper.updateById(score);
        }
    }
}
