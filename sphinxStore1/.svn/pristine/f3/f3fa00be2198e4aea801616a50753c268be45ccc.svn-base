package com.sphinx.beautea.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.customer.dao.CustomerDao;
import com.sphinx.beautea.customer.domain.Customer;
import com.sphinx.beautea.customer.service.CustomerService;
import com.sphinx.beautea.order.domain.Order;
import com.sphinx.beautea.order.service.OrderService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	OrderService orderService;
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		List<Order> orderList = orderService.getOrderListByCustomerId(customer.getCustomerId());
		for(Order order : orderList) {
			orderService.deleteOrder(order);
		}
		if(orderList.size() == 0) {
			customerDao.deleteCustomer(customer);
		}
	}

	@Override
	public Customer getCustomerById(String customerId) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerById(customerId);
	}

	@Override
	public List<Customer> getAllCustomerList(int page) {
		// TODO Auto-generated method stub
		return customerDao.findAllCustomerList(page);
	}

	@Override
	public List<Customer> getAdmin(int page) {
		// TODO Auto-generated method stub
		return customerDao.findAdmin(page);
	}

	@Override
	public List<Customer> getCustomerByDel(int page) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerByDel(page);
	}

	@Override
	public Customer getCustomerBySphinxId(String sphinxId) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerBySphinxId(sphinxId);
	}
	
	@Override
	public int countCustomer(boolean del) {
		
		return customerDao.countCustomer(del);
	}

	@Override
	public int countAdmin() {
		// TODO Auto-generated method stub
		return customerDao.countAdmin();
	}

	@Override
	public boolean idcheck(String sphinxId) {
		// TODO Auto-generated method stub
		return customerDao.idcheck(sphinxId);
	}

}
