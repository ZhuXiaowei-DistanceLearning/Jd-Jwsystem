package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.exception.BadRequestException;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TCourse;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.CourseDTO;
import com.zxw.jwxt.dto.StudentDTO;
import com.zxw.jwxt.mapper.TCourseMapper;
import com.zxw.jwxt.vo.QueryCourseVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public RS deletePeople(String cid) {
        TCourse tCourse = courseMapper.selectOne(this.queryOne("id", cid));
        if (tCourse != null) {
            tCourse.setPeople(tCourse.getPeople() - 1);
            int i = courseMapper.update(tCourse, this.queryOne("id", cid));
            return i == 1 ? RS.ok() : RS.error("操作失败");
        }
        throw new BadRequestException("该课程不存在");
    }

    public List listajax(QueryCourseVO courseVO) {
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotEmpty(courseVO.getSystemId())) {
            params.put("system_id", courseVO.getSystemId());
        }
        if (StringUtils.isNotEmpty(courseVO.getNatureId())) {
            params.put("nature_id", courseVO.getNatureId());
        }
        if (StringUtils.isNotEmpty(courseVO.getNatureId())) {
            params.put("cstatus_id", courseVO.getCstatusId());
        }
        Map<String, Object> keyword = new HashMap<>();
        if (StringUtils.isNotEmpty(courseVO.getKeyword())) {
            keyword.put("name", courseVO.getKeyword());
        }
        return courseMapper.selectList(this.getWrapper(courseVO, keyword, params));
    }

    public IPage endApply(QueryCourseVO courseVO, UserRealm realm) {
        IPage<CourseDTO> iPage = courseMapper.courseApply(this.getPage(courseVO), realm.getCollegeId());
        return iPage;
    }

    public RS updateCourseEnd(QueryCourseVO courseVO) {
        TCourse course = courseMapper.selectOne(this.queryOne("id", courseVO.getId()));
        if (course != null) {
            switch (courseVO.getEndStatus()) {
                case "apply":
                    course.setEnd(1);
                    break;
                case "agree":
                    course.setEnd(2);
                    break;
                case "reject":
                    course.setEnd(3);
                    break;
            }
            int i = courseMapper.updateById(course);
            return i == 1 ? RS.ok() : RS.error("操作失败");
        }
        throw new BadRequestException("该课程不存在");
    }

    public List<TCourse> selectAll(String teamId) {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("team_id", teamId);
        wrapper.eq("end", "1");
        List list = courseMapper.selectList(wrapper);
        return list;
    }
}
