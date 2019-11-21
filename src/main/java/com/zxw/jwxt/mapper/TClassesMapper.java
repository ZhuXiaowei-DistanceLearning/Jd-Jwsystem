package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    @Select("SELECT DISTINCT\n" +
            "\t\tc.*,s.`name`,s.`status`,s.`college_id`,t.`name` tname,t.`status`\n" +
            "\t\ttstatus FROM\n" +
            "\t\t`t_classes` c LEFT JOIN `t_specialty`\n" +
            "\t\ts ON\n" +
            "\t\tc.`specialty_id`\n" +
            "\t\t= s.`id` LEFT JOIN `t_college` t ON s.`college_id`=t.`id`")
    List<QueryClassesVO> findAll(IPage page);
}
