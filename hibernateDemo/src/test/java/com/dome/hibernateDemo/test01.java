package com.dome.hibernateDemo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
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
           for(int i=0;i<10;i++) {
        	   User user = new User();
               user.setUserName("王"+i);
               session.save(user);
           }
           
           
           
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
    
    @Test  //排序查询
    public void demo11() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();

           Query query = session.createQuery("from User order by id desc");
           List<User> list = query.list();
           for(User user : list) {
                  System.out.println(user);
           }
           
           session.getTransaction().commit();
    }
    
    @Test  //HQL条件查询
    public void demo12() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();

           Query query = session.createQuery("from User where userName like :aaa and password = :bbb");
           query.setParameter("aaa", "王%");
           query.setParameter("bbb", "111");

           List<User> list = query.list();
           for(User user : list) {
                  System.out.println(user);
           }
           
           session.getTransaction().commit();
    }
    
    			
    @Test  //HQL投影查询//查询对象的某个或某些属性 
    public void demo13() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           //查询多个属性，
           List<User> list = session.createQuery("select new User(userName,password) from User").list();
           for (User user : list) {
			System.out.println(user);
		}
           
           session.getTransaction().commit();
    }
    @Test  //HQL分组统计查询 
    public void demo14() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           //聚合函数的使用：count(),max(),min(),avg(),sum()都可以
//           Object object = session.createQuery("select count(*) from User").uniqueResult();
//			System.out.println(object);
           List<Object[]> objects = session.createQuery("select password,count(*) from User group by password HAVING count(*)>=2").list();
           for (Object[] objects2 : objects) {
			System.out.println(Arrays.toString(objects2));
		}
           
           session.getTransaction().commit();
    }
    
    
    @Test  
    public void demo15() {
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
        
           CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
           CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
           //指定根条件
           Root<User> root = criteriaQuery.from(User.class);
           //创建查询条件
           Predicate namePredicate = criteriaBuilder.like(root.get("userName"), "王%");
           criteriaQuery.where(criteriaBuilder.and(namePredicate));
           
           List<User> list = session.createQuery(criteriaQuery).list();
           
           for (User user : list) {
			System.out.println(user);
           }

           session.getTransaction().commit();
    }
    @Test  
    public void demo17() {
    	//web层
    	DetachedCriteria detachedcriteria = DetachedCriteria.forClass(User.class);
    	detachedcriteria.add(Restrictions.like("userName", "王%"));
    	//dao层
           HibernateUtils hibernateUtils = new HibernateUtils();
           Session session = hibernateUtils.getCurrentSession();
           session.beginTransaction();
           
           Criteria criteria = detachedcriteria.getExecutableCriteria(session);
           List<User> list = criteria.list();
           for (User user : list) {
			System.out.println(user);
           }

           session.getTransaction().commit();
    }
}
