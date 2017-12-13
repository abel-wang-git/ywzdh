package com.wang.base.service.impl;

import com.wang.base.dao.BaseMapper;
import com.wang.base.entity.BaseEntity;
import com.wang.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Administrator on 2017/12/8.
 */
public class BaseServiceImpl<M extends BaseEntity,PK> implements BaseService<M,PK> {
    @Autowired
    BaseMapper<M,PK> baseMapper;
    @Override
    public PK save(M m) {
        return baseMapper.save(m);
    }

    @Override
    public void delete(PK pk) {
        baseMapper.delete(getNewInstance(),pk);
    }

    @Override
    public List<M> findAll() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<M> clazz = (Class<M>) pt.getActualTypeArguments()[0];
        return baseMapper.findAll(getNewInstance());
    }

    @Override
    public List<M> findOne(PK pk)  {

        return baseMapper.findOne(getNewInstance(),pk);
    }

    @Override
    public Long count() {
        return baseMapper.count();
    }

    M getNewInstance(){
        M m = null;
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<M> clazz = (Class<M>) pt.getActualTypeArguments()[0];
            m = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return m;
    }

}
