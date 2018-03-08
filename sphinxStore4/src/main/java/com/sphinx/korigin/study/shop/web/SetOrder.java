package com.sphinx.korigin.study.shop.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dug.controller.command.Command;
import com.dug.dao.member.MemberDao;
import com.dug.dao.member.impl.MemberDaojdbcImpl;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.member.Member;
import com.dug.domain.shop.Item;
import com.dug.domain.shop.Order;
import com.dug.util.Utill;
import com.dug.vto.shop.Cart;

public class SetOrder extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Utill utill = new Utill();
		List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");

		ItemDao iDao = ItemDaoImpl.getInstance();
		MemberDao id = MemberDaojdbcImpl.getInstance();

		Member member = id.findMember((String) session.getAttribute("userId"));
		Order order = new Order();
		
		if(cartList == null) { //바로 구매
			Item item = iDao.selectItem(request.getParameter("num"));
			int count = Integer.parseInt(request.getParameter("count"));
			order.setItemIdList(utill.stringToList(item.getNum()));
			order.setItemNumList(utill.stringToList("" + count));
			order.setPrice(item.getPrice()* count); // 상품 합계 가격(할인조건x)
		//	order.setTotalPrice(itemPrice * count); // 결제금액(할인조건o, 할인적용필요)
		} else { 
			float totalPrice = 0; // 결제금액(할인조건o, 할인적용필요)
			float price = 0; // 상품 합계 가격(할인조건x)
		
			List<String> idList = new ArrayList<>();
			List<String> countList = new ArrayList<>();

			for (Cart cvo : cartList) {
				idList.add(cvo.getItemId());
				countList.add(cvo.getCount());
				price += (iDao.selectItem(cvo.getItemId()).getPrice()
						* Integer.parseInt(cvo.getCount()));
			}
			// 총상품금액 (할인적용x)
			order.setBuyer(member);
			order.setItemIdList(idList);
			order.setItemNumList(countList);
			order.setPrice(price);
			order.setTotalPrice(totalPrice);
			request.setAttribute("totalPrice", price);
		}
		session.setAttribute("order", order);
		request.setAttribute("name", member.getName());
		request.setAttribute("email", member.getEmail());
		request.setAttribute("phone", member.getPhonenumber());

		return getNextPage();

	}

}
