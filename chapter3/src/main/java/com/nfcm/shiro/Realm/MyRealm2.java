package com.nfcm.shiro.Realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyRealm2 extends AuthorizingRealm {

    //认证信息，
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String password = new String(upToken.getPassword());
        //模拟用户名密码是否正确
        return new SimpleAuthenticationInfo("test",password,getName());

    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户名
        String username = (String)getAvailablePrincipal(principals);
        //模拟从数据库查询出来对应的角色和权限
        Set<String> roles = new HashSet<String>();
        roles.add("role_3");
        roles.add("role_4");

        Set<String> permissions = new HashSet<String>();
        permissions.add("user:update");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }


}
