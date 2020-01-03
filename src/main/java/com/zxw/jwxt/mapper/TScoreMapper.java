package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.domain.TScore;
import com.zxw.jwxt.dto.CourseDTO;
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
public interface TScoreMapper extends BaseMapper<TScore> {
    /**
     * 查询出对应学生
     *
     * @param ids
     * @return
     */
    @Select("SELECT DISTINCT s.*,t.`sid`,t.`sname`,t.`sex` FROM `t_score`\n" +
            "\t\ts LEFT JOIN `t_student` t ON s.`Student_id`=t.`sid` WHERE\n" +
            "\t\ts.`course_id`=#{value};")
    List<TScore> findStudentId(String ids);


    /**
     * 查询出对应学生
     *
     * @param ids
     * @return
     */
    @Select("SELECT *,c.`name` cousename FROM (`t_score` s,`t_student` st,`t_section`\n" +
            "\t\tse,`t_week`\n" +
            "\t\tw,`t_nature` n,`t_classes` cl,`t_college` co,`t_specialty`\n" +
            "\t\tsp)\n" +
            "\t\tLEFT JOIN `t_course` c ON\n" +
            "\t\ts.`course_id`=c.`id`\n" +
            "\t\tLEFT JOIN `t_teacher`\n" +
            "\t\tt ON c.`teacher_id`=t.`tid`\n" +
            "\t\tWHERE c.`nature_id`=n.`id` AND\n" +
            "\t\tc.`week_id`=w.`id` AND\n" +
            "\t\tc.`section_id`=se.`id` AND\n" +
            "\t\tst.`classes_id`=cl.`id` AND cl.`specialty_id` =sp.`id` AND\n" +
            "\t\tsp.`college_id` = co.`id` AND s.`Student_id`=st.`sid` AND\n" +
            "\t\tst.`sid`=#{value}")
    List<TScore> findAllCourseByStudentId(String ids);

    /**
     * 查询学生个人成绩
     *
     * @param ids
     * @return
     */
    @Select("SELECT s.*,se.*,w.*,n.*,sp.`name` spname,co.`name`\n" +
            "\t\t\t\t\t\t\t\t\t\t  cname,c.`name` cousename,tm.`name` tmname,te.`name` ename,ct.`name` csname,n.`name` nname,c.`credit`\n" +
            "\t\tFROM (`t_score` s,`t_student` st,`t_section`\n" +
            "\t\t\tse,`t_week`\n" +
            "\t\t\tw,`t_nature`\n" +
            "\t\t\tn,`t_classes` cl,`t_college` co,`t_specialty`\n" +
            "\t\t\tsp)\n" +
            "\t\t\t\t LEFT JOIN `t_course` c\n" +
            "\t\t\t\t\t\t   ON\n" +
            "\t\t\t\t\t\t\t   s.`course_id`=c.`id`\n" +
            "\t\t\t\t LEFT JOIN `t_examway` te\n" +
            "\t\t\t\t\t\t   ON te.`id` = c.`way_id`\n" +
            "\t\t\t\t LEFT JOIN `t_cstatus` ct\n" +
            "\t\t\t\t\t\t   ON c.`cstatus_id` = ct.`id`\n" +
            "\t\t\t\t LEFT JOIN `t_team` tm\n" +
            "\t\t\t\t\t\t   ON tm.`id` = c.`team_id`\n" +
            "\t\tWHERE\n" +
            "\t\t\tc.`nature_id`=n.`id` AND c.`week_id`=w.`id`\n" +
            "\t\t  AND\n" +
            "\t\t\tc.`section_id`=se.`id`\n" +
            "\t\t  AND st.`classes_id`=cl.`id` AND\n" +
            "\t\t\tcl.`specialty_id` =sp.`id` AND\n" +
            "\t\t\tsp.`college_id` = co.`id` AND\n" +
            "\t\t\ts.`Student_id`=st.`sid` AND\n" +
            "\t\t\tst.`sid`=#{value}")
    List<TScore> findStudentScore(String ids);

    /**
     * 添加课程成绩对应页面
     *
     * @param courseId
     * @return
     */
    @Select("SELECT DISTINCT s.*,st.*,c.`classname`,sp.`name`,cl.`name`\n" +
            "\t\tcname FROM `t_score` s LEFT JOIN `t_student` st ON\n" +
            "\t\ts.`Student_id`=st.`sid`\n" +
            "\t\tLEFT JOIN `t_classes` c ON\n" +
            "\t\tst.`classes_id`=c.`id`\n" +
            "\t\tLEFT JOIN `t_specialty` sp ON\n" +
            "\t\tc.`specialty_id`=sp.`id`\n" +
            "\t\tLEFT JOIN\n" +
            "\t\t`t_college` cl ON\n" +
            "\t\tsp.`college_id`=cl.`id` WHERE course_id = #{value}")
    IPage addStudentScore(IPage iPage, String courseId);


    @Select("SELECT c.`id`,c.`name`,c.`classroom`,t.`tname` teacherName,te.`name` tname,w.`time` wname,se.`section` sse,se.`week` sw FROM `t_score` s,`t_course` c,`t_teacher` t,`t_team` te,`t_student` ts,`t_week` w,`t_nature` n,`t_section` se WHERE s.`student_id` = ts.`sid` AND s.`course_id` = c.`id` AND c.`nature_id` = n.`id` AND c.`team_id` = te.`id` AND c.`week_id` = w.`id` AND c.`teacher_id` = t.`tid` AND se.`id`= c.`section_id` AND ts.`sid` = #{sid} AND s.`status` = 0")
    List<CourseDTO> findSelectCourseByStudentId(String sid);
}
