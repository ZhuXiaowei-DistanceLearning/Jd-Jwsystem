package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.dto.CourseDTO;
import com.zxw.jwxt.dto.StudentDTO;
import com.zxw.jwxt.mapper.TCourseMapper;
import com.zxw.jwxt.vo.QueryCourseVO;
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
public class CourseService extends BaseService {

    @Autowired
    private TCourseMapper courseMapper;

    public RS addPeople(int i, String id) {
        TCourse course = new TCourse();
        course.setPeople(i);
        course.setId(id);
        return courseMapper.updateById(course) == 0 ? RS.error("选课人数添加失败") : RS.ok();
    }

    public TCourse findById(String courseid) {
        TCourse course = courseMapper.selectById(courseid);
        return course;
    }

    public IPage pageQuery(QueryCourseVO courseVO) {
        Page page = getPage(courseVO);
        return courseMapper.findAll(page);
    }


    public IPage findCourseByteacherId(QueryCourseVO courseVO, String id) {
        IPage iPage = courseMapper.findCourseByteacherId(getPage(courseVO), id);
        return iPage;
    }

    public RS add(TCourse model) {
        if (model.getWayId().equals("1")) {
            model.setIsExam(1);
        } else {
            model.setIsExam(0);
        }
        return courseMapper.insert(model) == 0 ? RS.error("添加失败") : RS.ok();
    }

    public List<CourseDTO> findScheduleByTeacher(String tid, String teamId) {
        List<CourseDTO> list = courseMapper.findScheduleByTeacher(tid, teamId);
        return list;
    }

    public IPage findStudentByCourseId(QueryCourseVO courseVO) {
        IPage<StudentDTO> page = courseMapper.findStudentByCourseId(this.getPage(courseVO), courseVO.getId());
        return page;
    }

    public List<CourseDTO> findScheduleByStudent(String userId, String teamId) {
        List<CourseDTO> list = courseMapper.findScheduleByStudent(userId, teamId);
        return list;
    }

    public RS updatePeople(String cid) {
        TCourse tCourse = courseMapper.selectOne(this.queryOne("id", cid));
        tCourse.setPeople(tCourse.getPeople() + 1);
        int i = courseMapper.updateById(tCourse);
        return i == 1 ? RS.ok() : RS.error("操作失败");
    }
}
