package com.dome.hibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
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
           user.setUserName("王帅");
           User user1 = new User();
           user1.setUserName("王啦");
           User user2 = new User();
           user2.setUserName("李想");
           session.save(user);
           session.save(user1);
           session.save(user2);
           
           session.getTransaction().commit();
    }
    
    
    @Test
    public void demo2() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //get
//           User user = session.get(User.class, 1l);
          
          //load
           User user = session.load(User.class, 1l);
           System.out.println(user);
           session.getTransaction().commit();
    }
    
    @Test
    public void demo3() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           //先查询再修改
           User user = session.get(User.class, 1l);
           user.setUserName("aaa");
           session.saveOrUpdate(user);
           session.getTransaction().commit();
    }
    
    @Test
    public void demo4() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //先查询再删除--级联删除
           User user = session.get(User.class, 1l);
           session.delete(user);
           
           session.getTransaction().commit();
    }
    
    @Test
    public void demo5() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //先查询再更新
           User user = session.get(User.class, 2l);
           user.setUserName("lala");
           session.saveOrUpdate(user);
           
           session.getTransaction().commit();
    }
    
    @Test
    public void demo6() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //先查询再更新
           User user = session.get(User.class, 2l);
           user.setUserName("lala");
           session.saveOrUpdate(user);
           
           session.getTransaction().commit();
    }
    
    @Test
    public void demo7() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //HQL:Hibernate Query Language 面向对象的查询语言
           Query query = session.createQuery("from User where userName like ?");
           query.setParameter(0, "王%");
           List<User> list = query.list();
           for(User user : list) {
        	   System.out.println(user);
           }
           
           session.getTransaction().commit();
    }
    
    @Test
    public void demo9() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //HQL:Hibernate Query Language 面向对象的查询语言
           Query query = session.createQuery("from User");
           query.setFirstResult(0);
           query.setMaxResults(3);
           List<User> list = query.list();
           for(User user : list) {
                  System.out.println(user);
           }
           
           session.getTransaction().commit();
    }
    
    @Test
    public void demo10() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();

           Criteria criteria = session.createCriteria(User.class);
           criteria.add(Restrictions.like("userName", "王%"));
           criteria.setFirstResult(0);
           criteria.setMaxResults(3);
           List<User> list = criteria.list();
           for(User user : list) {
                  System.out.println(user);
           }
           
           session.getTransaction().commit();
    }
    
    
}
