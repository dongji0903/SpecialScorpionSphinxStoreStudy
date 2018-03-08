package com.sphinx.korigin.study.shop.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dug.controller.command.Command;
import com.dug.dao.member.MemberDao;
import com.dug.dao.member.impl.MemberDaojdbcImpl;
import com.dug.dao.shop.OrderDao;
import com.dug.dao.shop.SaleManageDao;
import com.dug.dao.shop.StockManagementDao;
import com.dug.dao.shop.impl.OrderDaoImpl;
import com.dug.dao.shop.impl.SaleManagementDaoImpl;
import com.dug.dao.shop.impl.StockManagementDaoImpl;
import com.dug.domain.member.Member;
import com.dug.domain.shop.Order;

public class DoPayment extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberDao id = MemberDaojdbcImpl.getInstance();
		SaleManageDao smd = SaleManagementDaoImpl.getInstance();
		StockManagementDao stmd = StockManagementDaoImpl.getInstance();
		OrderDao od = OrderDaoImpl.getInstance();
		
		String userId = (String) session.getAttribute("userId");
		Order order = (Order) session.getAttribute("order");
		
		Member buyer = new Member();
		buyer.setName(request.getParameter("orderName"));
		buyer.setEmail(request.getParameter("orderEmail"));
		buyer.setPhonenumber(request.getParameter("orderPhone"));
		
		order.setBuyer(buyer);
		order.setReceiverName(request.getParameter("receiverName"));
		order.setReceiverAddress(request.getParameter("receiverAddr"));
		order.setGiverWant(request.getParameter("giverWant"));
		
		int point = id.findPoint(userId);

		// 간단한 결제 오류(포인트부족), 구체적 결제 실패에 대한 처리가 필요
		if (point < order.getTotalPrice()) {
			System.out.println(
					"결제금액: " + order.getTotalPrice() + ", 포인트: " + point);
			String paymentAlert = "포인트가 부족합니다";
			request.setAttribute("paymentAlert", paymentAlert);

		} else {
			
			// 결제시 포인트를 차감하여 update
			point -= order.getTotalPrice();
			id.updatePoint(userId, point);
			request.setAttribute("point", point);
			order.setDate(new Timestamp(new Date().getTime()));
			od.insertOrder(order);
			
			//주문 횟수,재고 업로드
			for(int i =0 ; i < order.getItemIdList().size();i++) {
			smd.updateNumOfSale(order.getItemIdList().get(i));
			stmd.updateStock(order.getItemIdList().get(i),
					Integer.parseInt(order.getItemNumList().get(i)));
			}
		}
		return getNextPage();
	}

}
