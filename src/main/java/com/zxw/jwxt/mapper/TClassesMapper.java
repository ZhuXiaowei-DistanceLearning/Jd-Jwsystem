package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TClasses;
import com.zxw.jwxt.domain.TCollege;
import com.zxw.jwxt.vo.QueryClassesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Mapper
public interface TClassesMapper extends BaseMapper<TClasses> {

    @Select("select cs.*,s.name sname,c.name cname,g.name gname from `t_classes` cs,`t_specialty` s,`t_college` c,`t_grade` g where cs.`collegeId` = c.`id` and cs.`specialtyId` = s.`id` and g.`id` = cs.`gradeId`")
    IPage<QueryClassesVO> findAll(Page page);

    @Select("select cs.*,s.name sname,c.name cname,g.name gname from `t_classes` cs,`t_specialty` s,`t_college` c,`t_grade` g where cs.`collegeId` = c.`id` and cs.`specialtyId` = s.`id` and g.`id` = cs.`gradeId` where cs.`collegeId` = #{collegeId}")
    IPage<QueryClassesVO> findByJwUser(Page page, @Param("collegeId") String collegeId);
}
