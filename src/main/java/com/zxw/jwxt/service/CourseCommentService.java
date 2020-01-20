package com.zxw.jwxt.service;

import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.CourseComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.mapper.CourseCommentMapper;
import com.zxw.jwxt.vo.QueryCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2020-01-15
 */
@Service
public class CourseCommentService extends BaseService {

    @Autowired
    private CourseCommentMapper courseCommentMapper;

    public RS add(CourseComment courseComment) {
        int i = courseCommentMapper.insert(courseComment);
        return i == 1 ? RS.ok() : RS.error("添加失败");
    }

    public CommentDTO queryCourseComment(QueryCommentVO commentVO, UserRealm realm) {
        CommentDTO commentDTO = courseCommentMapper.queryCourseComment(commentVO,realm.getId());
        return commentDTO;
    }
}
