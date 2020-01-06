package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TTeacher;
import com.zxw.jwxt.domain.TeacherRole;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.CourseDTO;
import com.zxw.jwxt.mapper.TTeacherMapper;
import com.zxw.jwxt.vo.QueryCourseVO;
import com.zxw.jwxt.vo.QueryTeacherVO;
import com.zxw.jwxt.dto.ScheduleDTO;
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
        QueryWrapper wrapper = getWrapper(teacherVO, null);
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

    public Object[][] findSchedule(QueryCourseVO queryCourseVO, String userId) {
        Object[][] arr = new Object[5][7];
        List<CourseDTO> list = courseService.findScheduleByTeacher(userId, queryCourseVO.getTeamId());
        list.forEach(e -> {
            ScheduleDTO scheduleDTO = new ScheduleDTO(e.getName(), e.getWname(), e.getNname(), e.getClassroom());
            switch (e.getSse()) {
                case "1-2节":
                    parseSchedule(arr, e, scheduleDTO,0);
                    break;
                case "3-4节":
                    parseSchedule(arr, e, scheduleDTO,1);
                    break;
                case "5-6节":
                    parseSchedule(arr, e, scheduleDTO,2);
                    break;
                case "7-8节":
                    parseSchedule(arr, e, scheduleDTO,3);
                    break;
                case "9-10节":
                    parseSchedule(arr, e, scheduleDTO,4);
                    break;
            }
        });
        return arr;
    }

    private void parseSchedule(Object[][] arr, CourseDTO e, ScheduleDTO scheduleDTO,int i) {
        switch (e.getSw()) {
            case "周一":
                arr[i][0] = scheduleDTO;
                break;
            case "周二":
                arr[i][1] = scheduleDTO;
                break;
            case "周三":
                arr[i][2] = scheduleDTO;
                break;
            case "周四":
                arr[i][3] = scheduleDTO;
                break;
            case "周五":
                arr[i][4] = scheduleDTO;
                break;
            case "周六":
                arr[i][5] = scheduleDTO;
                break;
            case "周日":
                arr[i][6] = scheduleDTO;
                break;
        }
    }


    public List listajax(UserRealm realm) {
        List list = teacherMapper.selectList(this.queryOne("college_id", realm.getCollegeId()));
        return list;
    }
}
