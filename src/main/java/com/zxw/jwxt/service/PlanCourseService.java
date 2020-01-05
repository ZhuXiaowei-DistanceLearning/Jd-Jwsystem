package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.common.pojo.RS;
import com.zxw.jwxt.domain.PlanCourse;
import com.zxw.jwxt.mapper.PlanCourseMapper;
import com.zxw.jwxt.vo.QueryPlanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
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
        IPage iPage = planCourseMapper.findAll(this.getPage(planVO), planVO.getPlanId());
        return iPage;
    }

    public RS add(QueryPlanVO planVO) {
        int insert = 0;
        for (int i = 0; i < planVO.getCids().length; i++) {
            PlanCourse planCourse = new PlanCourse();
            planCourse.setPlanId(planVO.getPlanId());
            planCourse.setCourseId(planVO.getCids()[i]);
            insert = planCourseMapper.insert(planCourse);
        }
        return insert == 1 ? RS.ok() : RS.error("操作失败");
    }

    public RS edit(PlanCourse plan) {
        int insert = planCourseMapper.updateById(plan);
        return insert == 1 ? RS.ok() : RS.error("操作失败");
    }

    public RS delete(String id) {
        int insert = planCourseMapper.deleteById(id);
        return insert == 1 ? RS.ok() : RS.error("操作失败");
    }
}
