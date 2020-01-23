package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TeamComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-04
 */
@Mapper
public interface TeamCommentMapper extends BaseMapper<TeamComment> {

    @Select("SELECT tc.*,teacher.`tname` teacherName,course.`name` courseName,c.`commentType` FROM `team_comment` tc,`t_comments` c,`t_teacher` teacher,`t_course` course WHERE tc.`comment_id` = c.`id` AND tc.`comment_id` = c.`id` AND tc.`tid`  = teacher.`tid` AND course.`id` = tc.`cid` AND course.`teacher_id` = teacher.tid AND tc.sid = #{sid} AND tc.`comment_id` = #{commentId}")
    IPage<CommentDTO> findAll(Page page, @Param("sid") String sid, @Param("commentId") String commentId);

    @Select("SELECT course.`id` cid,teacher.`tname` teacherName,course.`name` courseName,c.`commentType`,c.`id` FROM `t_comments` c,`t_teacher` teacher,`t_course` course WHERE course.`teacher_id` = teacher.tid AND c.`id` = #{commentId} AND course.`team_id` = c.`team_id` AND teacher.`tid` = #{teacherId} and course.`comment` = 1")
    IPage<CommentDTO> findTeacher(Page page, @Param("teacherId") String teacherId, @Param("commentId") String commentId);

    /**
     * @param page
     * @param id    评价id
     * @param teacherId 教师id
     * @param courseId  课程id
     * @return
     */
    @Select("SELECT s.`sid`,course.`id` cid,tc.remark,tc.`status`, tc.`id`,s.`sname` FROM  `team_comment` tc,`t_comments` c,`t_teacher` t,`t_student` s,`t_course` course WHERE tc.`comment_id` = c.`id` AND tc.`sid` = s.`sid` AND tc.`tid` = t.`tid` AND c.`id` = #{id} AND tc.`tid` =#{teacherId} AND course.`id` = tc.`cid` AND course.`id` = #{courseId}")
    IPage<CommentDTO> findStudentComment(Page page, @Param("id") String id, @Param("teacherId") String teacherId, @Param("courseId") String courseId);
}
