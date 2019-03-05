package com.qfedu.shiroadmin.controller;

import com.qfedu.shiroadmin.comment.sysconst.SystemCon;
import com.qfedu.shiroadmin.comment.vo.ResultVo;
import com.qfedu.shiroadmin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("userlogin.do")
    public ResultVo login(String name,String password){
        System.out.println("到这了");
        ResultVo resultVo = service.login(name, password);
        if(resultVo.getCode() == SystemCon.OK){
            // 需告知shiro
            //1、创建登录令牌
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            //2、获取主题
            Subject subject = SecurityUtils.getSubject();
            //3、在session设置当前登录用户
            subject.getSession().setAttribute("user",resultVo.getData());
            //4、发起认证---调用shiro对应的realm的认证方法
            subject.login(token);
        }
        return resultVo;
    }
}
