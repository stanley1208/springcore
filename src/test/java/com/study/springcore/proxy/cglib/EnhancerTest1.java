package com.study.springcore.proxy.cglib;

public class EnhancerTest1 {

	public static void main(String[] args) {
		// 使用子類別 (增強) 來代理
		Customer customer=new EnhancerCustomer();
		System.out.println(customer.buy("麵包"));
	}

}
