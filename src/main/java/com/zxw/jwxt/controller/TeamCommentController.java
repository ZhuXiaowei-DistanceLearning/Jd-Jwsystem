package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.service.TeamCommentService;
import com.zxw.jwxt.vo.QueryCommentVO;
import com.zxw.jwxt.vo.QueryTeamCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-12-30
 */
@RestController
@RequestMapping("/api/teamComment")
public class TeamCommentController extends BaseController {
    @Autowired
    private TeamCommentService teamCommentService;

    @GetMapping("/pageQuery")
    public ResponseEntity pageQuery(QueryTeamCommentVO teamCommentVO){
        IPage page =  teamCommentService.pageQuery(teamCommentVO);
        TableReponse of = TableReponse.of(page);
        return ResponseEntity.ok(of);
    }
}
