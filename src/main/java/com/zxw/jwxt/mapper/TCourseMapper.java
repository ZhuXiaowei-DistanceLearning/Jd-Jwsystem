package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CourseDTO;
import com.zxw.jwxt.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Mapper
public interface TCourseMapper extends BaseMapper<TCourse> {
    @Select("SELECT c.`name`,c.`id`,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName,teacher.`tname` teacherName,c.`credit`,c.`point`,c.`people`,c.`totalPeople`,c.`classroom`,c.`total_time` FROM t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher WHERE c.week_id = w.id AND c.way_id = e.id AND c.team_id = t.id AND c.section_id = s.id AND c.nature_id = n.id AND c.cstatus_id = cs.id AND c.college_id = co.id AND c.teacher_id = teacher.tid AND c.`status` = '1'")
    IPage<CourseDTO> findAll(Page page);

    @Select("select c.*,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName from t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher WHERE c.week_id = w.id and c.way_id = e.id and c.team_id = t.id and c.section_id = s.id and c.nature_id = n.id and c.cstatus_id = cs.id and c.college_id = co.id and c.teacher_id = teacher.tid and c.teacher_id = #{tid}")
    IPage<CourseDTO> findCourseByteacherId(Page page, @Param("tid") String tid);

    @Select("select c.*,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName from t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher WHERE c.week_id = w.id and c.way_id = e.id and c.team_id = t.id and c.section_id = s.id and c.nature_id = n.id and c.cstatus_id = cs.id and c.college_id = co.id and c.teacher_id = teacher.tid and c.teacher_id = #{tid} and c.team_id = #{teamId}")
    List<CourseDTO> findScheduleByTeacher(@Param("tid") String tid, @Param("teamId") String teamId);

    @Select("SELECT st.`sname`,st.`sid`,c.`classname` cname,sp.`name` spname,tc.`name` tcname,g.`name` gname,s.`absent`,s.`attendance`,s.`usually`,s.`exam`,s.`score` FROM `t_score` s,`t_student` st,`t_classes` c,`t_specialty` sp,`t_college` tc,`t_grade` g WHERE s.`student_id` = st.`sid` AND st.`classes_id` = c.`id` AND c.`college_id` = tc.`id` AND c.`specialty_id` = sp.`id` AND c.`grade_id` = g.`id` AND s.`course_id` = #{id}")
    IPage<StudentDTO> findStudentByCourseId(Page page, @Param("id") String id);

    @Select("SELECT c.`name`,c.`classroom`,t.`tname` teacherName,te.`name` tname,w.`time` wname,se.`section` sse,se.`week` sw FROM `t_score` s,`t_course` c,`t_teacher` t,`t_team` te,`t_student` ts,`t_week` w,`t_nature` n,`t_section` se WHERE s.`student_id` = ts.`sid` AND s.`course_id` = c.`id` AND c.`nature_id` = n.`id` AND c.`team_id` = te.`id` AND c.`week_id` = w.`id` AND c.`teacher_id` = t.`tid` AND se.`id`= c.`section_id` AND ts.`sid` = #{sid} and c.team_id = #{teamId}")
    List<CourseDTO> findScheduleByStudent(@Param("sid") String userId, @Param("teamId") String teamId);
}
