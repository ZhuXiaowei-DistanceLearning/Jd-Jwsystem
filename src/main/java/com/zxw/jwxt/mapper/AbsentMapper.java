package com.zxw.jwxt.mapper;

import com.zxw.jwxt.domain.Absent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-29
 */
@Mapper
public interface AbsentMapper extends BaseMapper<Absent> {

    @Select("SELECT * FROM `absent` ab WHERE ab.`sid` = #{userId} AND ab.`create_time` BETWEEN #{beginDate} AND #{endDate}")
    List<Absent> countStudentAbsent(@Param("userId") String userId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}
