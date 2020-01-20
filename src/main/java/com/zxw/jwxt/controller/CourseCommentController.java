package com.zxw.jwxt.controller;


import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.CourseComment;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.service.CourseCommentService;
import com.zxw.jwxt.vo.QueryCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zxw.jwxt.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2020-01-15
 */
@RestController
@RequestMapping("/api/courseComment")
public class CourseCommentController extends BaseController {
    @Autowired
    private CourseCommentService courseCommentService;

    @PostMapping
    public ResponseEntity add(@RequestBody CourseComment courseComment) {
        RS rs = courseCommentService.add(courseComment);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/queryCourseComment")
    public ResponseEntity queryCourseComment(QueryCommentVO commentVO) {
        CommentDTO commentDTO = courseCommentService.queryCourseComment(commentVO, getRealm());
        return ResponseEntity.ok(commentDTO);
    }
}
