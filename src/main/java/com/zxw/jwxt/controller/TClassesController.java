package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableResponse;
import com.zxw.jwxt.domain.TClasses;
import com.zxw.jwxt.service.ClassesService;
import com.zxw.jwxt.vo.QueryClassesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/api/classes")
public class TClassesController extends BaseController {
    @Autowired
    private ClassesService classesService;

    /**
     * 分页查询
     *
     * @return
     * @throws IOException
     */
    @GetMapping("/pageQuery")
    public TableResponse pageQuery(QueryClassesVO queryClassesVO) {
        IPage result = classesService.pageQuery(queryClassesVO, getRealm());
        TableResponse reponse = TableResponse.of(result);
        return reponse;
    }

    /**
     * 添加班级
     *
     * @param classes
     * @return
     */
    @PostMapping("/add")
    public RS add(@RequestBody TClasses classes) {
        return classesService.save(classes);
    }

    /**
     * 删除班级
     *
     * @param classesVO
     * @return
     */
    @GetMapping("/delete")
    public RS delete(QueryClassesVO classesVO) {
        return classesService.deleteBatch(classesVO);
    }

    @GetMapping("/findById")
    public RS findById(String ids, HttpSession session) {
        session.setAttribute("classes_id", ids);
        return RS.ok();
    }
}
