package com.zxw.jwxt.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.domain.TComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxw.jwxt.dto.CommentDTO;
import com.zxw.jwxt.vo.QueryClassesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxw
 * @since 2020-01-04
 */
@Mapper
public interface TCommentsMapper extends BaseMapper<TComments> {
    @Select("select c.*,t.`name` tname from t_comments c,t_team t where c.team_id = t.id")
    IPage<CommentDTO> findAll(Page page);
}
