package com.nfcm.shiro;

import com.nfcm.shiro.Utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;

public class MyRealmTest2
{
    public static void main(String[] args) {
        ShiroUtils.login("classpath:shiro-myrealm2.ini","zhang","123456");

        Subject subject = SecurityUtils.getSubject();

        List<String> principals =subject.getPrincipals().asList();
        for (String principal:principals) {
            System.out.println(principal);
        }

        System.out.println(subject.getPrincipals().getPrimaryPrincipal());
        //是否通过认证
        System.out.println(subject.isAuthenticated());
        //是否有role1角色
        System.out.println(subject.hasRole("role_1"));
        //realm2里面的角色
        System.out.println(subject.hasRole("role_3"));

        System.out.println(subject.isPermitted("user:create"));
        //realm2里面的资源
        System.out.println(subject.isPermitted("user:update"));
    }
}
