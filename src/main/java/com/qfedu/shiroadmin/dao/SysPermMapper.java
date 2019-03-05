package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.pojo.SysPerm;

public interface SysPermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPerm record);

    int insertSelective(SysPerm record);

    SysPerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPerm record);

    int updateByPrimaryKey(SysPerm record);
}