package com.xp_spring_aop.demo2;

public class OrderDao {
	
	public void save() {
		System.out.println("save product……");
	}

	
	public void update() {
		System.out.println("update product……");
	}

	
	public void find() {
		System.out.println("find product……");
		int i = 1/0;
	}

	
	public String delete() {
		System.out.println("delete product……");
		return "小可爱";
	}
}
