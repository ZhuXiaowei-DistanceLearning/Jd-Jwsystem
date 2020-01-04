package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.domain.TeamComment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.mapper.TeamCommentMapper;
import com.zxw.jwxt.vo.QueryCommentVO;
import com.zxw.jwxt.vo.QueryTeamCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxw
 * @since 2020-01-04
 */
@Service
public class TeamCommentService extends BaseService{

    @Autowired
    private TeamCommentMapper teamCommentMapper;

    public IPage pageQuery(QueryTeamCommentVO teamCommentVO) {
        IPage iPage = teamCommentMapper.selectPage(this.getPage(teamCommentVO), this.getWrapper(teamCommentVO, null));
        return iPage;
    }
}
