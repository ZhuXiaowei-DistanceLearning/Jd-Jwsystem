package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CourseDTO;
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
    @Select("SELECT *, tc.`name` AS cname, tn.`name` nname, te.`name` ename, cs.`name` csname, tm.`name` tmname\n" +
            "        FROM `t_course` c,\n" +
            "             `t_section` ts,\n" +
            "             `t_week` tw,\n" +
            "             `t_teacher` tt,\n" +
            "             `t_nature` tn,\n" +
            "             `t_college` tc,\n" +
            "             `t_team` tm,\n" +
            "             `t_examway` te,\n" +
            "             `t_cstatus` cs\n" +
            "        WHERE c.`nature_id` = tn.`id`\n" +
            "          AND c.`cstatus_id` = cs.`id`\n" +
            "          AND c.`section_id` = ts.`id`\n" +
            "          AND c.`college_id` = tc.`id`\n" +
            "          AND c.`teacher_id` = tt.`tid`\n" +
            "          AND c.`team_id` = tm.`id`\n" +
            "          AND c.`way_id` = te.`id`\n" +
            "          AND c.`week_id` = tw.`id`")
    IPage findAll(Page page);

    @Select("select c.*,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName from t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher WHERE c.week_id = w.id and c.way_id = e.id and c.team_id = t.id and c.section_id = s.id and c.nature_id = n.id and c.cstatus_id = cs.id and c.college_id = co.id and c.teacher_id = teacher.tid and c.teacher_id = #{tid}")
    IPage<CourseDTO> findCourseByteacherId(Page page, @Param("tid") String tid);

    @Select("select c.*,w.time wname,n.`name` nname,s.`week` sw,s.section sse,cs.`name` csname,e.`name` ename,t.`name` tname,co.`name` collegeName from t_course c,t_nature n,t_week w,t_section s,t_cstatus cs, t_examway e,t_team t,t_college co,t_teacher teacher WHERE c.week_id = w.id and c.way_id = e.id and c.team_id = t.id and c.section_id = s.id and c.nature_id = n.id and c.cstatus_id = cs.id and c.college_id = co.id and c.teacher_id = teacher.tid and c.teacher_id = #{tid} and c.team_id = #{teamId}")
    List<CourseDTO> findScheduleByTeacher(@Param("tid") String tid, @Param("teamId") String teamId);
}
