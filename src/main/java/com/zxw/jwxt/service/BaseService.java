package com.zxw.jwxt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxw.jwxt.vo.BaseQueryParam;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zxw
 * @date 2019/11/16 17:50
 */
public class BaseService {
    public Page getPage(BaseQueryParam baseQueryParam) {
        Page page = new Page(baseQueryParam.getOffset(), baseQueryParam.getLimit());
        if (baseQueryParam.getSort() != null) {
            OrderItem orderItems = new OrderItem();
            orderItems.setColumn(baseQueryParam.getSort());
            orderItems.setAsc(baseQueryParam.isASC());
            page.addOrder(orderItems);
        }
        return page;
    }

    public QueryWrapper getWrapper(BaseQueryParam baseQueryParam, Object... params) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (baseQueryParam.getKeyword() != null) {
            Map<String, Object> keyword = baseQueryParam.getKeyword();
            Set<String> strings = keyword.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                Object o = keyword.get(next);
                queryWrapper.like(next, o);
            }
        }
        if (StringUtils.isNotEmpty(baseQueryParam.getStatus())) {
            queryWrapper.eq("status", baseQueryParam.getStatus());
        }
        if (StringUtils.isNotEmpty(baseQueryParam.getGroupBy())) {
            queryWrapper.groupBy(baseQueryParam.getGroupBy());
        }
        if (params.length != 0) {
            Map<String, Object> map = (Map<String, Object>) params[0];
            Set<String> strings = map.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                Object o = map.get(next);
                if (o != null) {
                    queryWrapper.eq(next, o);
                }
            }
        }
        return queryWrapper;
    }
}
