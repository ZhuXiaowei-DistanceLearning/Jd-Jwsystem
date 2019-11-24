package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TCollege;
import com.zxw.jwxt.mapper.TCollegeMapper;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CollegeService extends BaseService {

    @Autowired
    private TCollegeMapper collegeMapper;

    /**
     * 先通过id查在更新
     */
    public RS delete(String ids) {
        String[] id = ids.split(",");
        for (String string : id) {
            TCollege tCollege = collegeMapper.selectById(string);
            UpdateWrapper<TCollege> wrapper = new UpdateWrapper<>();
            if (tCollege.getStatus().equals("1")) {
                tCollege.setStatus("0");
            } else {
                tCollege.setStatus("1");
            }
            collegeMapper.updateById(tCollege);
        }
        return RS.ok();
    }

    public RS edit(TCollege college) {
        int update = collegeMapper.update(college, new UpdateWrapper<>());
        return update == 1 ? RS.ok() : RS.error("修改失败");
    }

    public List<TCollege> findListNostatus() {
        QueryWrapper<TCollege> wrapper = new QueryWrapper();
        wrapper.eq("status", "1");
        List<TCollege> list = collegeMapper.selectList(wrapper);
        return list;
    }

    public IPage pageQuery(BaseQueryParam baseQueryParam) {
        Page page = getPage(baseQueryParam);
        QueryWrapper queryWrapper = getWrapper(baseQueryParam);
        IPage iPage = collegeMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    public RS save(TCollege model) {
        int count;
        TCollege tCollege = collegeMapper.selectById(model.getId());
        if (tCollege != null) {
            count = collegeMapper.updateById(model);
        } else {
            count = collegeMapper.insert(model);
        }
        return count == 0 ? RS.error("更新或修改失败") : RS.ok();
    }

}
