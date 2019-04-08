package com.dome.hibernateDemo;

import org.hibernate.Session;
import org.junit.Test;

import com.dome.hibernateDemo.Utils.HibernateUtils;

//many-to-one  hbm.xml配置测试
public class test03 {
	@Test
	public void test01() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码
		Customer customer1 = new Customer();
		customer1.setCname("c1");
		Customer customer2 = new Customer();
		customer2.setCname("c2");
		
		Order order1 = new Order();
		order1.setOname("o1");
		Order order2 = new Order();
		order2.setOname("o2");
		Order order3 = new Order();
		order3.setOname("o3");
		
		order1.setCustomer(customer1);
		order2.setCustomer(customer2);
		order3.setCustomer(customer2);
		customer1.getOrders().add(order1);
		customer2.getOrders().add(order2);
		customer2.getOrders().add(order3);
		
		session.save(order1);
		session.save(order2);
		session.save(order3);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void test02() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码
		/*
		 * customer放弃外键维护权
		 */
		Customer customer1 = new Customer();
		customer1.setCname("c1");
		
		Order order1 = new Order();
		order1.setOname("o1");
		
		customer1.getOrders().add(order1);
		
		session.save(customer1);//order1的外键为null
		
		session.getTransaction().commit();
	}
	
	@Test
	public void test03() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码
		/*
		 * customer放弃外键维护权
		 */
		Customer customer1 = new Customer();
		customer1.setCname("c1");
		session.save(customer1);
		
		Order order1 = new Order();
		order1.setOname("o1");
		order1.setCustomer(customer1);
		session.save(order1);
		
		session.getTransaction().commit();
	}
}
