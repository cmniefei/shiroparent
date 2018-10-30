package com.nfcm.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroRoleTest {
    public static void main(String[] args) {
        Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-role.ini");
        //得到安全管理器
        SecurityManager securityManager = factory.getInstance();
        //将securityManager托管给SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123456");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //是否已经认证
        System.out.println(subject.isAuthenticated());

        //校验是否有对应的权限和资源，如果没有则抛出对应的异常UnauthorizedException
        subject.checkRole("role1");
        subject.checkPermission("user:create");
        //退出
        subject.logout();

    }
}
