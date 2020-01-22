package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.domain.CourseComment;
import com.zxw.jwxt.dto.CourseCommentDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-15
 */
public interface CourseCommentMapper extends BaseMapper<CourseComment> {

    @Select("SELECT cc.*,tc.`remark`,course.`name`,tc.`status` FROM `course_comment` cc,`team_comment` tc,`t_team` t,`t_comments` c,`t_course` course,`t_student` student WHERE cc.`tm_id` = tc.`id` AND tc.`comment_id` = c.`id` AND c.`team_id` = t.`id` AND tc.`cid` = course.`id` and student.`sid` = #{studentId} AND course.`id` = #{courseId} AND tc.`id` = #{tcId};")
    CourseCommentDTO queryCourseComment(@Param("courseId") String courseId, @Param("tcId") String tcId, @Param("studentId") String studentId);
}
