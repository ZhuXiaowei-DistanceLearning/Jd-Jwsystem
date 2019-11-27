package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.vo.QueryStudentVO;
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
public interface TStudentMapper extends BaseMapper<TStudent> {
    /**
     * 根据教室id查询出对应的学生
     *
     * @param cid
     * @return
     */
    @Select("select * FROM `t_student` s,`t_classes` c where s.`classes_id`=c.`id` WHERE c.`id`=#{cid}")
    Page<QueryStudentVO> findStudentByClassesId(Page page, @Param("cid") String cid);

}
