package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TeamComment;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.mapper.TeamCommentMapper;
import com.zxw.jwxt.vo.QueryTeamCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2020-01-04
 */
@Service
public class TeamCommentService extends BaseService {

    @Autowired
    private TeamCommentMapper teamCommentMapper;

    public TeamComment selectById(String id) {
        return teamCommentMapper.selectById(id);
    }

    public RS update(TeamComment teamComment) {
        int i = teamCommentMapper.updateById(teamComment);
        return i == 1 ? RS.ok() : RS.error("操作异常");
    }

    public IPage pageQuery(QueryTeamCommentVO teamCommentVO, String userId) {
        IPage<CommentDTO> iPage = teamCommentMapper.findAll(this.getPage(teamCommentVO), userId, teamCommentVO.getCommentId());
        return iPage;
    }
}
