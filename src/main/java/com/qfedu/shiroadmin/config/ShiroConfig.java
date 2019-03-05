package com.qfedu.shiroadmin.config;

import com.qfedu.shiroadmin.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
//标记这是一个配置
public class ShiroConfig {
    //    1、编写realm  创建类  继承默认的realm
    @Bean
    public UserRealm createRealm() {
        return new UserRealm();
    }

    //    2、生成权限管理器
    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm);
        return webSecurityManager;
    }

    //    3、配置过滤器工程
    @Bean
    public ShiroFilterFactoryBean createShiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//        设置三个路径  一个管理器
        factoryBean.setLoginUrl("login.html");
        factoryBean.setSuccessUrl("index.html");
        factoryBean.setUnauthorizedUrl("error.html");
        factoryBean.setSecurityManager(defaultWebSecurityManager);
//        设置放行和拦截的资源
//      放行静态资源，css,js,图片
        Map<String, String> map = new HashMap<>();
        map.put("/media/**", "anon");
        map.put("/login.html", "anon");
        map.put("/userlogin.do", "anon");
//        剩下的全部拦截
        map.put("/**", "authc");
//        anon 不登陆就可以访问
//        authc 必须登录才可以访问
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
