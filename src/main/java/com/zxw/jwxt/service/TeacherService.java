package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.domain.TeacherRole;
import com.zxw.jwxt.mapper.TTeacherMapper;
import com.zxw.jwxt.vo.QueryCourseVO;
import com.zxw.jwxt.vo.QueryTeacherVO;
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
public class TeacherService extends BaseService {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TTeacherMapper teacherMapper;

    @Autowired
    private TeacherRoleService teacherRoleService;

    public TTeacher findByUsername(String username) {
        TTeacher tTeacher = teacherMapper.selectById(username);
        return tTeacher;
    }

    public IPage pageQuery(QueryTeacherVO teacherVO) {
        Page page = getPage(teacherVO);
        QueryWrapper wrapper = getWrapper(teacherVO,null);
        IPage iPage = teacherMapper.selectPage(page, wrapper);
        return iPage;
    }

    public List<TTeacher> findListNoStatusAndCollege(String id) {
//        List<TTeacher> list = teacherMapper.findListNoStatusAndCollege(id);
//        return list;
        return null;
    }

    public RS save(TTeacher model, String roleIds) {
        teacherMapper.insert(model);
        String[] ids = roleIds.split(",");
        for (String id : ids) {
            TeacherRole record = new TeacherRole();
            record.setRoleId(id);
            record.setTeacherId(model.getId());
            teacherRoleService.insertRole(record);
        }
        return RS.ok();
    }

    public TTeacher findInfo(String tid) {
        TTeacher teacher = teacherMapper.selectById(tid);
        return teacher;
    }

    public List findSchedule(QueryCourseVO queryCourseVO, String userId) {
        return null;
    }
}
