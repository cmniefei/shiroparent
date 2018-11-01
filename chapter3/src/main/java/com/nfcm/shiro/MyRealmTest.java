package com.nfcm.shiro;

import com.nfcm.shiro.Utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class MyRealmTest {
    public static void main(String[] args) {
        ShiroUtils.login("classpath:shiro-myrealm.ini","zhang","123456");

        Subject subject = SecurityUtils.getSubject();
        //是否通过认证
        System.out.println(subject.isAuthenticated());
        //是否有role1角色
        System.out.println(subject.hasRole("role_1"));

        System.out.println(subject.isPermitted("user:create"));

    }
}
