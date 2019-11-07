package com.zxw.jwxt.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zxw.jwxt.domain.TStudent;
import com.zxw.jwxt.mapper.TStudentMapper;
import com.zxw.jwxt.service.ITStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxw
 * @since 2019-11-07
 */
@Service
public class TStudentServiceImpl implements ITStudentService {

    @Override
    public boolean save(TStudent entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<TStudent> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<TStudent> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<TStudent> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(TStudent entity) {
        return false;
    }

    @Override
    public boolean update(TStudent entity, Wrapper<TStudent> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<TStudent> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(TStudent entity) {
        return false;
    }

    @Override
    public TStudent getById(Serializable id) {
        return null;
    }

    @Override
    public Collection<TStudent> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public Collection<TStudent> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public TStudent getOne(Wrapper<TStudent> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<TStudent> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<TStudent> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<TStudent> queryWrapper) {
        return 0;
    }

    @Override
    public List<TStudent> list(Wrapper<TStudent> queryWrapper) {
        return null;
    }

    @Override
    public IPage<TStudent> page(IPage<TStudent> page, Wrapper<TStudent> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<TStudent> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<TStudent> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<TStudent> page, Wrapper<TStudent> queryWrapper) {
        return null;
    }

    @Override
    public BaseMapper<TStudent> getBaseMapper() {
        return null;
    }
}
