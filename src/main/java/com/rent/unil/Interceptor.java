package com.rent.unil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.rent.entity.Users;

import java.awt.*;
import java.util.Map;

/**
 * 定义一个拦截器类
 */
public class Interceptor extends AbstractInterceptor {


    /**
     * 拦截的方法
     * @param actionInvocation
     * @return
     * @throws Exception
     */
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        //获得会话
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Users user =(Users) session.get("user");
        if(user==null){
            //表示登录未成功，继续跳到登录页面
           return Action.LOGIN;
        }
        //继续执行调用action中对应的方法。
        return actionInvocation.invoke();
    }
}
