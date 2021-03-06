package com.sphinx.beautea.customer.service;

import java.util.List;

import com.sphinx.beautea.customer.domain.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	//여기서 부턴 우리 조만의 메서드
	public Customer getCustomerById(String customerId); //PK로 찾기
	
	public List<Customer> getAllCustomerList(int page); //회원 관리페이지에서 사용될 메서드
	
	public List<Customer> getAdmin(int page); //관리자만 찾기
	
	public List<Customer> getCustomerByDel(int page); //탈퇴 처리된 회원 찾기
	
	public Customer getCustomerBySphinxId(String sphinxId); //회원아이디로 회원찾기
	
	public boolean idcheck(String sphinxId); // 회원가입할 때 아이디 중복 체크
	
	public int countCustomer(boolean del);
	
	public int countAdmin();
}
