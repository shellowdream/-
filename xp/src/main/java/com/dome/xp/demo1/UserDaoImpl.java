package com.dome.xp.demo1;

public class UserDaoImpl implements UserDao {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void save() {
		System.out.println("UserDAOImpl执行了..."+name);
	}

}
