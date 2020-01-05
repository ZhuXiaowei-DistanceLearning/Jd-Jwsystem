package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.PlanCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.PlanDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-05
 */
public interface PlanCourseMapper extends BaseMapper<PlanCourse> {

    @Select("SELECT pc.`id`,pc.`plan_id` planId,c.`id` courseId,c.`credit`,c.`point`,n.`name` nname,co.`name` coname,cs.`name` csname,c.name cname,c.`total_time`,system.`name` systemName FROM `plan_course` pc,`t_course` c,`t_nature` n,`t_college` co,`t_cstatus` cs,`course_system` system WHERE pc.`course_id` = c.`id` AND c.`nature_id` = n.`id` AND co.`id` = c.`college_id` AND system.`id` = c.`system_id` AND c.`cstatus_id` = cs.`id` AND pc.`plan_id` = #{planId}")
    IPage<PlanDTO> findAll(Page page, @Param("planId") String planId);
}
