package com.dome.xp.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userdao")//相当于<bean name="userDAO" class="com.dome.xp.demo1.UserDaoImpl" ></bean>
public class Userdao {
	private String name;
	@Value("笨笨")
	public void setName(String name) {
		this.name = name;
	}

	public void save() {
		System.out.println("UserDAOImpl执行了..."+name);
	}

}
