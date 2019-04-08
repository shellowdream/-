package com.dome.xp.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dome.xp.demo2.Userdao;



public class test1 {
	@Test
	/**
	 * 传统方式的调用
	 */
	public void demo1(){
		UserDaoImpl userDAO = new UserDaoImpl();
		userDAO.save();
	}
	
	@Test
	/**
	 * Spring的方式的调用
	 */
	public void demo2(){
		// 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDAO = (UserDao) applicationContext.getBean("userDAO");
		userDAO.save();
	}
	
	@Test
	public void test3(){
		// 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Userdao userdao = (Userdao) applicationContext.getBean("userdao");
		userdao.save();
	}
	
	
}
