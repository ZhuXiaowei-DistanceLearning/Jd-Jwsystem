package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TClasses;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.mapper.TClassesMapper;
import com.zxw.jwxt.vo.QueryClassesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class ClassesService extends BaseService {
    @Autowired
    private TClassesMapper classesMapper;

    public RS save(TClasses classes) {
        return classesMapper.insert(classes) == 0 ? RS.error("保存失败") : RS.ok("保存成功");
    }

    public IPage pageQuery(QueryClassesVO queryClassesVO) {
        Page page = getPage(queryClassesVO);
        QueryWrapper wrapper = getWrapper(queryClassesVO);
        IPage iPage = classesMapper.selectPage(page, wrapper);
        return iPage;
    }

    public RS deleteBatch(QueryClassesVO classesVO) {
        return RS.ok();
    }
}
