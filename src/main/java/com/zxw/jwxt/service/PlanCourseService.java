package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.mapper.PlanCourseMapper;
import com.zxw.jwxt.vo.QueryPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxw
 * @since 2020-01-05
 */
@Service
public class PlanCourseService extends BaseService {
    @Autowired
    private PlanCourseMapper planCourseMapper;


    public IPage pageQuery(QueryPlanVO planVO) {
        IPage iPage = planCourseMapper.findAll(this.getPage(planVO),planVO.getId());
        return iPage;
    }

}
