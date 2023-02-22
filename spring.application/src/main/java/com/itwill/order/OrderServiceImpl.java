package com.itwill.order;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;

	@Override
	public List<Order> list() {
		return orderDao.orderList();
	}
	
	
}
