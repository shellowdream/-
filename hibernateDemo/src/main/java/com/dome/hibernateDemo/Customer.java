package com.dome.hibernateDemo;

import java.util.HashSet;
import java.util.Set;

//客户 一
public class Customer {
	private Long cid;
	private String cname;
	private Set<Order> orders = new HashSet<Order>();
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", orders=" + orders + "]";
	}
	
}
