package com.rent.filter;


import com.rent.unil.HibernateUtil;
import org.hibernate.Transaction;

//import javax.servlet.*;
import java.io.IOException;

public class OpenSessionInViewFilter{


//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        Transaction transaction=null;
//        try {
//            //请求到达，打开session和事务
//            transaction= HibernateUtil.openSession().beginTransaction();
//            //执行请求处理链
//            filterChain.doFilter(servletRequest,servletResponse);
//            transaction.commit();
//        }catch (Exception e){
//            if(transaction!=null){
//                transaction.rollback();
//            }
//        }
//    }
//
//    public void destroy() {
//
//    }
}
