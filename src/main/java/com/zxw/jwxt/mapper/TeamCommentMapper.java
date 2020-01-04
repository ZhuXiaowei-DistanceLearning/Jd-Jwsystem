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
}
