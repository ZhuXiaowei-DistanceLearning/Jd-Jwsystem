package com.zxw.jwxt.mapper;

import com.zxw.jwxt.domain.CourseComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.vo.QueryCommentVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-15
 */
public interface CourseCommentMapper extends BaseMapper<CourseComment> {

    CommentDTO queryCourseComment(QueryCommentVO commentVO, String id);
}
