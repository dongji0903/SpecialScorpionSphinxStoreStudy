package com.sphinx.beautea.customer.web.controller.mypage.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sphinx.beautea.category.service.LinkBnCService;
import com.sphinx.beautea.common.domain.Board;
import com.sphinx.beautea.common.domain.PageUtil;
import com.sphinx.beautea.common.service.BoardService;
import com.sphinx.beautea.customer.domain.Customer;

@Controller
public class MyQnAController {
	@Autowired
	BoardService boardService;
	@Autowired
	LinkBnCService bncService;
	
	@RequestMapping(value = "/mypage/myqna", method = RequestMethod.GET)
	public String myQnA(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer)session.getAttribute("customer");
		
		String categoryId = request.getParameter("categoryId");
		
		//페이지
		String pageStr = "";
		try {
			pageStr = request.getParameter("page");
		} catch(NullPointerException | NumberFormatException e) {
			pageStr = "1";
		}
		int page = Integer.parseInt(pageStr);
		PageUtil pageUtil = new PageUtil();
		int count = boardService.countBoards(false);
		List<Integer> pageList = pageUtil.getPages(count, page);
		
		//보드
		
		
		List<Board> boardList = boardService.getBoardListByCustomerId(customer.getCustomerId(), page);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageList", pageList);
		request.setAttribute("maxPage", pageUtil.getMaxPage(count));
		return "customer/mypage/board/myqna";
	}
	
	
}
