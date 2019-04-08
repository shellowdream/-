package com.dome.hibernateDemo;

import org.hibernate.Session;
import org.junit.Test;

import com.dome.hibernateDemo.Utils.HibernateUtils;

//manytomany
public class test04 {
	@Test
	public void test01() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码
		Actor actor1 = new Actor();
		actor1.setName("a1");
		Actor actor2 = new Actor();
		actor2.setName("a2");
		
		Role role1 = new Role();
		role1.setName("r1");
		Role role2 = new Role();
		role2.setName("r2");
		Role role3 = new Role();
		role3.setName("r3");

		
		actor1.getRoles().add(role1);
		actor1.getRoles().add(role3);
		actor2.getRoles().add(role1);
		actor2.getRoles().add(role2);
		
		
		session.save(actor1);
		session.save(actor2);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void test02() {
		HibernateUtils hibernateUtils = new HibernateUtils();
		Session session = hibernateUtils.getCurrentSession();
		session.beginTransaction();
		
		//事务代码 修改 将2号演员选择的1号角色修改为2号角色
		//查询1号演员
		Actor actor = session.get(Actor.class, 2l);
		//查询2，3号角色
		Role role1 = session.get(Role.class, 1l);
		Role role2 = session.get(Role.class, 2l);
		actor.getRoles().remove(role1);
		actor.getRoles().add(role2);
		
		
		session.getTransaction().commit();
	}
}
