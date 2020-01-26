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
    @Select("SELECT c.`name`,tc.`id`,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName,teacher.`tname` teacherName,c.`credit`,tc.`people`,tc.`total_people`,tc.`classroom`,c.`total_time`,tc.`end` FROM t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher,`teacher_course` tc WHERE tc.week_id = w.id AND tc.`cid` = c.`id` AND c.way_id = e.id AND tc.team_id = t.id AND tc.section_id = s.id AND c.nature_id = n.id AND c.cstatus_id = cs.id AND c.college_id = co.id AND c.`system_id` = '4' AND tc.teacher_id = teacher.tid AND tc.`status` = '1'")
    IPage<CourseDTO> findAll(Page page);

    @Select("SELECT c.`name`,c.`id`,teacher.`tid`,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName,teacher.`tname` teacherName,c.`credit`,c.`total_time`,tc.`end` FROM t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher,`teacher_course` tc WHERE tc.`cid` = c.`id` and tc.week_id = w.id AND c.way_id = e.id AND tc.team_id = t.id AND tc.section_id = s.id AND c.nature_id = n.id AND c.cstatus_id = cs.id AND c.college_id = co.id AND tc.`teacher_id` = teacher.tid AND tc.`status` = '1' and tc.`end` = 1 and c.`college_id` = #{collegeId}")
    IPage<CourseDTO> courseApply(Page page, @Param("collegeId") String collegeId);

    @Select("SELECT c.*,tc.`end`,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName FROM t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher,`teacher_course` tc WHERE tc.week_id = w.id AND tc.`cid` = c.`id` AND c.way_id = e.id AND tc.team_id = t.id AND tc.section_id = s.id AND c.nature_id = n.id AND c.cstatus_id = cs.id AND c.college_id = co.id AND tc.teacher_id = teacher.tid AND tc.teacher_id = #{tid}")
    IPage<CourseDTO> findCourseByteacherId(Page page, @Param("tid") String tid);

    @Select("select c.*,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName from t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher,`teacher_course` tc WHERE tc.week_id = w.id and c.way_id = e.id and tc.team_id = t.id and tc.section_id = s.id and c.nature_id = n.id and c.cstatus_id = cs.id and c.college_id = co.id and tc.teacher_id = teacher.tid and tc.`cid` = c.`id` and tc.teacher_id = #{tid} and tc.team_id = #{teamId}")
    List<CourseDTO> findScheduleByTeacher(@Param("tid") String tid, @Param("teamId") String teamId);

    @Select("SELECT st.`sname`,st.`sid`,s.`teacher_id` tid,c.`classname` cname,sp.`name` spname,tc.`name` tcname,g.`name` gname,s.`absent`,s.`attendance`,s.`usually`,s.`exam`,s.`score` FROM `t_score` s,`t_student` st,`t_classes` c,`t_specialty` sp,`t_college` tc,`t_grade` g WHERE s.`student_id` = st.`sid` AND st.`classes_id` = c.`id` AND c.`college_id` = tc.`id` AND c.`specialty_id` = sp.`id` AND c.`grade_id` = g.`id` AND s.`course_id` = #{id}")
    IPage<StudentDTO> findStudentByCourseId(Page page, @Param("id") String id);

    @Select("SELECT tc.`id`,c.`name`,tc.`classroom`,t.`tname` teacherName,te.`name` tname,w.`time` wname,se.`section` sse,se.`week` sw FROM `t_score` s,`t_course` c,`t_teacher` t,`t_team` te,`t_student` ts,`t_week` w,`t_nature` n,`t_section` se,`teacher_course` tc WHERE s.`student_id` = ts.`sid` AND s.`course_id` = tc.`cid` AND tc.`cid` = c.`id` AND c.`nature_id` = n.`id` AND tc.`team_id` = te.`id` AND tc.`week_id` = w.`id` AND tc.`teacher_id` = t.`tid` AND se.`id`= tc.`section_id` AND ts.`sid` = #{sid} AND tc.team_id = #{teamId}")
    List<CourseDTO> findScheduleByStudent(@Param("sid") String userId, @Param("teamId") String teamId);
}
