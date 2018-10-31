package com.nfcm.shiro;

import com.nfcm.shiro.Utils.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class JdbcRealmTest {
    public static void main(String[] args) {
        ShiroUtils.login("classpath:shiro-jdbc.ini","zhang","123456");

        Subject subject = SecurityUtils.getSubject();
        //是否通过认证
        System.out.println(subject.isAuthenticated());
        //是否有role1角色
        System.out.println(subject.hasRole("role1"));

        System.out.println(subject.isPermitted("user:create"));


    }
}
