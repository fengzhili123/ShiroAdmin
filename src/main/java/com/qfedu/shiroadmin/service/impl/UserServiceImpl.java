package com.qfedu.shiroadmin.service.impl;

import com.qfedu.shiroadmin.comment.utils.ResultUtil;
import com.qfedu.shiroadmin.comment.vo.PageVo;
import com.qfedu.shiroadmin.comment.vo.ResultVo;
import com.qfedu.shiroadmin.dao.SysUserMapper;
import com.qfedu.shiroadmin.pojo.SysUser;
import com.qfedu.shiroadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private SysUserMapper dao;

    @Override
    public ResultVo insert(SysUser user, int rid) {

        return null;
    }

    @Override
    public PageVo<SysUser> queryPage(int page, int limit) {
        return null;
    }

    @Override
    public ResultVo login(String name, String password) {
        SysUser user = dao.selectByName(name);
        if (user != null){
            if (user.getPassword().equals(password)){
                return ResultUtil.exec(true,"OK",user);
            }
        }
        return ResultUtil.exec(false,"用户名或密码不正确",null);
    }
}
