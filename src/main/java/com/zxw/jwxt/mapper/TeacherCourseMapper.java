package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TeacherCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-26
 */
@Mapper
public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {

    @Select("SELECT c.`name`,tc.`id`,tc.`total_people`,tc.`classroom`,t.`tname`,s.`section` sse,s.`id` sectionId,w.`id` weekId,c.`id` cid, s.`week` sw,w.`time` wname,tc.`apply`  FROM `teacher_course` tc,`t_teacher` t,`t_course` c,`t_college` co,`t_section` s,`t_week` w,`t_team` te WHERE tc.`team_id` = te.`id` AND tc.`section_id` = s.`id` AND tc.`week_id` = w.`id` AND tc.`teacher_id` = t.`tid` AND tc.`cid` = c.`id` AND t.`college_id` = co.`id` AND tc.`apply` = 0 and co.`id` = #{collegeId}")
    IPage<CourseDTO> findApply(Page page, @Param("collegeId") String collegeId);

    @Select("SELECT c.`name`,tc.`total_people`,tc.`classroom`,t.`tname`,s.`section` sse,s.`week` sw,w.`time` wname,tc.`apply` FROM `teacher_course` tc,`t_teacher` t,`t_course` c,`t_college` co,`t_section` s,`t_week` w,`t_team` te WHERE tc.`team_id` = te.`id` AND tc.`section_id` = s.`id` AND tc.`week_id` = w.`id` AND tc.`teacher_id` = t.`tid` AND tc.`cid` = c.`id` AND t.`college_id` = co.`id` AND t.`tid`=#{id}")
    IPage<CourseDTO> findApplyByTeacher(Page page, @Param("id") String id);
}
