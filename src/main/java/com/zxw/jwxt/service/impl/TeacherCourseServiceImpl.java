package com.zxw.jwxt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxw.common.exception.BadRequestException;
import com.zxw.jwxt.domain.TeacherCourse;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.mapper.TeacherCourseMapper;
import com.zxw.jwxt.service.ITeacherCourseService;
import com.zxw.jwxt.vo.QueryCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zxw
 * @since 2020-01-26
 */
@Service
public class TeacherCourseServiceImpl extends ServiceImpl<TeacherCourseMapper, TeacherCourse> implements ITeacherCourseService {

    @Autowired
    private TeacherCourseMapper teacherCourseMapper;

    @Override
    public IPage findApply(QueryCourseVO queryCourseVO, UserRealm realm) {
        Page page = new Page(queryCourseVO.getOffset(), queryCourseVO.getLimit());
        IPage ipage = teacherCourseMapper.findApply(page, realm.getCollegeId());
        return ipage;
    }

    @Override
    public IPage findApplyByTeacher(QueryCourseVO queryCourseVO, UserRealm realm) {
        Page page = new Page(queryCourseVO.getOffset(), queryCourseVO.getLimit());
        IPage ipage = teacherCourseMapper.findApplyByTeacher(page, realm.getId());
        return ipage;
    }

    @Override
    public boolean agree(String id) {
        TeacherCourse teacherCourse = teacherCourseMapper.selectById(id);
        if (teacherCourse != null) {
            teacherCourse.setApply(1);
            teacherCourseMapper.updateById(teacherCourse);
            return true;
        }
        throw new BadRequestException("未查到该门课程");
    }

    @Override
    public boolean back(String id) {
        TeacherCourse teacherCourse = teacherCourseMapper.selectById(id);
        if (teacherCourse != null) {
            teacherCourse.setApply(2);
            teacherCourseMapper.updateById(teacherCourse);
            return true;
        }
        throw new BadRequestException("未查到该门课程");
    }
}
