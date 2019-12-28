package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.vo.QueryStudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 根据教室id查询出对应的学生
     *
     * @param cid
     * @return
     */
    @Select("select * FROM `t_student` s,`t_classes` c where s.`classes_id`=c.`id` and c.`id`=#{cid}")
    Page<QueryStudentVO> findAll(Page page, @Param("cid") String cid);

}
