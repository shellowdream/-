package com.dome.hibernateDemo;


//订单 多
public class Order {
	private Long id;
	private String oname;
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [oid=" + id + ", oname=" + oname + ", customer=" + customer + "]";
	}
	
}
