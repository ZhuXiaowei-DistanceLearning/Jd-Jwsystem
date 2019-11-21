package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.domain.TCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
    IPage findAll(IPage page);

    @Select("SELECT c.*,\n" +
            "               w.`id` wid,\n" +
            "               s.`id`\n" +
            "                      sid,\n" +
            "               n.`id` nid,\n" +
            "               n.`name`\n" +
            "                      nname,\n" +
            "               s.`section`,\n" +
            "               s.`week`,\n" +
            "               w.`time`,\n" +
            "               t.`tname`,\n" +
            "               t.`tid`\n" +
            "        FROM (`t_course`\n" +
            "              c, `t_week` w, `t_section`\n" +
            "              s, `t_nature` n, `t_teacher` t)\n" +
            "        WHERE c.`week_id` = w.`id`\n" +
            "          AND c.`section_id` = s.`id`\n" +
            "          AND c.`nature_id` = n.`id`\n" +
            "          AND c.`teacher_id` = t.`tid`\n" +
            "          AND t.`tid` = #{value}")
    IPage findCourseByteacherId(IPage page, String tid);
}
