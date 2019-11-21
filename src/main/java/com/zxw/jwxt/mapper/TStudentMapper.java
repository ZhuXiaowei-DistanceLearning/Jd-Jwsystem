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
    @Select("SELECT DISTINCT * FROM `t_student` s LEFT JOIN `t_classes` c ON\n" +
            "\t\ts.`classes_id`=c.`id` WHERE c.`id`=#{value}")
    Page<QueryStudentVO> findAll(Page page, @Param("cid") String cid);

}
