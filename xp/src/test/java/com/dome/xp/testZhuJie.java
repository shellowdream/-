package com.dome.xp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dome.xp.demo2.Userdao;

public class testZhuJie {
	@Test
	public void test3(){
		// 创建Spring的工厂
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Userdao userdao = (Userdao) applicationContext.getBean("userdao");
		userdao.save();
	}
	
}
