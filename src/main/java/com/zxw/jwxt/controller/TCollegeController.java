package com.zxw.jwxt.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.enums.ExceptionEnums;
import com.zxw.common.exception.JwException;
import com.zxw.common.pojo.RS;
import com.zxw.common.pojo.TableReponse;
import com.zxw.jwxt.domain.TCollege;
import com.zxw.jwxt.service.CollegeService;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/t-college")
public class TCollegeController extends BaseController {

    @Autowired
    private CollegeService collegeService;

    /**
     * 分页查询
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/pageQuery")
    @ResponseBody
    public TableReponse pageQuery(BaseQueryParam baseQueryParam) throws IOException {
        IPage iPage = collegeService.pageQuery(baseQueryParam);
        TableReponse result = TableReponse.of(iPage);
        return result;
    }

    /**
     * 增加学院
     *
     * @return
     */
    @PostMapping("addCollege")
    @ResponseBody
    public RS addCollege(TCollege model) {
        if (model == null) {
            throw new JwException(ExceptionEnums.NO_DATA);
        }
        return collegeService.save(model);
    }

    /**
     * 更改状态为不可用
     *
     * @return
     */
    @GetMapping("deleteCollege")
    @ResponseBody
    public RS delete(String ids) {
        RS result = collegeService.delete(ids);
        return result;
    }

    /**
     * findListNostatus找到
     *
     * @return
     */
    @PostMapping("editCollege")
    @ResponseBody
    public RS editCollege(@RequestBody TCollege model) {
        if (model == null) {
            throw new JwException(ExceptionEnums.NO_DATA);
        }
        return collegeService.edit(model);
    }

    /**
     * 查询列表
     */
    @RequestMapping("listajax")
    @ResponseBody
    public List<TCollege> listajax(HttpServletResponse response) throws IOException {
        List<TCollege> list = collegeService.findListNostatus();
        return list;
    }

}
