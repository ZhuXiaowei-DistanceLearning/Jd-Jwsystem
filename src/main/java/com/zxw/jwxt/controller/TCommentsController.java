package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.TableResponse;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.service.CommentsService;
import com.zxw.jwxt.vo.QueryCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/api/comment")
public class TCommentsController extends BaseController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/pageQuery")
    public ResponseEntity pageQuery(QueryCommentVO commentVO){
        IPage<CommentDTO> page =  commentsService.pageQuery(commentVO);
        TableResponse of = TableResponse.of(page);
        return ResponseEntity.ok(of);
    }

}
