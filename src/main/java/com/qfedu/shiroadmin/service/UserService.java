package com.qfedu.shiroadmin.service;

import com.qfedu.shiroadmin.comment.vo.PageVo;
import com.qfedu.shiroadmin.comment.vo.ResultVo;
import com.qfedu.shiroadmin.pojo.SysUser;

public interface UserService {
    //新增
    ResultVo insert(SysUser user, int rid);

    //查询分页
    PageVo<SysUser> queryPage(int page, int limit);

    //登录
    ResultVo login(String name, String password);
}
