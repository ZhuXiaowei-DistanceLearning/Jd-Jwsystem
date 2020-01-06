package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.CourseSystem;
import com.zxw.jwxt.dto.CourseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-05
 */
public interface CourseSystemMapper extends BaseMapper<CourseSystem> {

    @Select("SELECT c.`name`,c.`id`,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName,teacher.`tname` teacherName,c.`credit`,c.`point`,c.`people`,c.`totalPeople`,c.`classroom`,c.`total_time`,system.`name` FROM t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher,`course_system` system WHERE c.week_id = w.id AND c.way_id = e.id AND c.team_id = t.id AND c.section_id = s.id AND c.nature_id = n.id AND c.cstatus_id = cs.id AND c.college_id = co.id AND system.`id` = c.`system_id` AND  c.teacher_id = teacher.tid AND c.`status` = '1' AND c.`system_id` = #{systemId}")
    IPage<CourseDTO> findCourseBySystemId(Page page, @Param("systemId") String systemId);
}
