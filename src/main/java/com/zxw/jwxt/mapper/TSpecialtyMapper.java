package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.domain.TSpecialty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface TSpecialtyMapper extends BaseMapper<TSpecialty> {
    @Select("  SELECT DISTINCT s.`id`,\n" +
            "                        s.`name`,\n" +
            "                        s.`status`,\n" +
            "                        s.`college_id`,\n" +
            "                        c.`name` cname,\n" +
            "                        c.`status`\n" +
            "                                 cstatus,\n" +
            "                        c.`id`   cid\n" +
            "        FROM `t_specialty` s\n" +
            "                 LEFT JOIN `t_college` c ON\n" +
            "            s.`college_id` = c.`id` ORDER BY c.`name`")
    List<TSpecialty> findAll();

    @Update(" update t_specialty\n" +
            "        set status=1\n" +
            "        where id\n" +
            "                  = #{id,jdbcType=VARCHAR}")
    int deleteBatch(String id);
}
