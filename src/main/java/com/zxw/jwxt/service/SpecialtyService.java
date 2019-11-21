package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TSpecialty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxw.jwxt.mapper.TSpecialtyMapper;
import com.zxw.jwxt.vo.BaseQueryParam;
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
public class SpecialtyService extends BaseService {
    @Autowired
    private TSpecialtyMapper specialtyMapper;

    public RS add(TSpecialty model) {
        return specialtyMapper.insert(model) == 0 ? RS.error("插入失败") : RS.ok("插入成功");
    }

    /**
     * 数组id
     */
    public RS update(TSpecialty model) {
        return specialtyMapper.updateById(model) == 0 ? RS.error("更新失败") : RS.ok("更新成功");
    }

    public RS deleteBatch(String ids) {
        String[] id = ids.split(",");
        for (String spId : id) {
            specialtyMapper.deleteBatch(spId);
        }
        return RS.ok();
    }

    public IPage pageQuery(BaseQueryParam baseQueryParam) {
        Page page = getPage(baseQueryParam);
        QueryWrapper wrapper = getWrapper(baseQueryParam);
        IPage iPage = specialtyMapper.selectPage(page, wrapper);
        return iPage;
    }

    public RS redoSpecialty(String id) {
        TSpecialty tSpecialty = specialtyMapper.selectById(id);
        if (tSpecialty.getStatus().equals("1")) {
            tSpecialty.setStatus("0");
            specialtyMapper.updateById(tSpecialty);
        }
        return RS.ok();
    }
}
