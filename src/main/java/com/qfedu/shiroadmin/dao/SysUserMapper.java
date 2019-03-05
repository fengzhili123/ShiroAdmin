package com.qfedu.shiroadmin.dao;

import com.qfedu.shiroadmin.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    int insert(SysUser record);

    SysUser selectById(Integer id);

    SysUser selectByName(String name);

    int updateByIdSelective(SysUser record);

    int updateByFlag(@Param("id")int id,@Param("flag")int flag);

    int updateByPassword(@Param("id")int id,@Param("password")int password);
}