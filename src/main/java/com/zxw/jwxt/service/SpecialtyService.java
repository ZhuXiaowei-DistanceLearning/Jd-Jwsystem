package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TSpecialty;
import com.zxw.jwxt.mapper.TSpecialtyMapper;
import com.zxw.jwxt.vo.QuerySpecialtyVO;
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

        TSpecialty tSpecialty = specialtyMapper.selectById(ids);
        if (tSpecialty.getStatus().equals("1")) {
            tSpecialty.setStatus("0");
        } else {
            tSpecialty.setStatus("1");
        }
        return specialtyMapper.updateById(tSpecialty) == 0 ? RS.error("作废失败") : RS.ok();
    }

    public IPage pageQuery(QuerySpecialtyVO baseQueryParam) {
        Page<QuerySpecialtyVO> page = getPage(baseQueryParam);
        IPage<QuerySpecialtyVO> iPage = specialtyMapper.findAll(page);
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

    public RS saveOrUpdateSpeciatly(TSpecialty specialty) {
        int count;
        TSpecialty tSpecialty = specialtyMapper.selectById(specialty.getId());
        if (tSpecialty != null) {
            count = specialtyMapper.updateById(specialty);
        } else {
            count = specialtyMapper.insert(specialty);
        }
        return count == 0 ? RS.error("更新或修改失败") : RS.ok();
    }
}
