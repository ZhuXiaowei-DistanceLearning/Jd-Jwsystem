package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.mapper.TCommentsMapper;
import com.zxw.jwxt.vo.QueryCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
public class CommentsService extends BaseService {

    @Autowired
    private TCommentsMapper commentsMapper;

    public IPage pageQuery(QueryCommentVO commentVO) {
        IPage<CommentDTO> iPage = commentsMapper.findAll(this.getPage(commentVO));
        return iPage;
    }

}
