package com.nfcm.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestShiro1 {
    public static void main(String[] args) {
        Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro.ini");
        //得到安全管理器
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //是否已经认证
        System.out.println(subject.isAuthenticated());
        //退出
        subject.logout();

        System.out.println(subject.isAuthenticated());

    }
}
