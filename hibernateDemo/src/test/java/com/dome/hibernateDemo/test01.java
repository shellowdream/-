package com.dome.hibernateDemo;

import org.hibernate.Session;
import org.junit.Test;

import com.dome.hibernateDemo.Utils.HibernateUtils;

public class test01 {
    @Test
    public void demo1() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //事务代码
           User user = new User();
           user.setUserName("aaa");
           session.save(user);
           
           session.getTransaction().commit();
    }
}
