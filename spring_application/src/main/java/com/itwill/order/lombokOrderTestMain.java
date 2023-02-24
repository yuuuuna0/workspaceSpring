package com.itwill.order;

import java.time.LocalDateTime;
import java.util.Date;

public class lombokOrderTestMain {

	public static void main(String[] args) {
		Order order=new Order();
		order.setOrderNo(1);
		order.setOrderTitle("TV 외,,,");
		order.setOrderDate(new Date());
		System.out.println(order);
		Order order2=new Order(2,"Phone 외,,,",new Date());
		System.out.println(order2);
	}
}
