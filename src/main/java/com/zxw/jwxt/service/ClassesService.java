package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.TClasses;
import com.zxw.jwxt.domain.UserRealm;
import com.zxw.jwxt.mapper.TClassesMapper;
import com.zxw.jwxt.vo.QueryClassesVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    public IPage pageQuery(QueryClassesVO queryClassesVO, UserRealm realm) {
        IPage<QueryClassesVO> iPage = null;
        Page page = getPage(queryClassesVO);
        Map<String, Object> map = new HashMap<>();
        map.put("cs.`college_id`", queryClassesVO.getCollegeId());
        map.put("cs.`specialty_id`", queryClassesVO.getSpecialtyId());
        map.put("cs.`grade_id`", queryClassesVO.getGradeId());
        if (StringUtils.isNotEmpty(queryClassesVO.getCollegeId()) || StringUtils.isNotEmpty(queryClassesVO.getSpecialtyId()) || StringUtils.isNotEmpty(queryClassesVO.getGradeId())) {
            iPage = classesMapper.findByParams(page, this.getWrapper(queryClassesVO, map));
        } else {
            iPage = classesMapper.findAll(page);
        }
        return iPage;
    }

    public RS deleteBatch(QueryClassesVO classesVO) {
        return RS.ok();
    }
}
