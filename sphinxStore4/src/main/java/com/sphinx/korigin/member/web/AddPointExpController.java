package com.sphinx.korigin.member.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.sphinx.korigin.member.service.MemberService;

@Controller
public class AddPointExpController{

	/*@Autowired
	private CustomerService customerService;
	@RequestMapping(value="AddPointExp",method=RequestMethod.POST)
	public String execute(ModelMap m, 
			@RequestParam("point")int point,
			@RequestAttribute("userId")String userId,
			@RequestParam("exp")int exp) {
		int point = 0;
		int exp = 0;
		
		if (m.getParameter("point") != "") {
			point = Integer.parseInt(request.getParameter("point"));
		} else if (request.getAttribute("point") != "") {
			point = (Integer) request.getAttribute("point");
		}
		int afterPoint = mdao.findPoint((String) request.getAttribute("userId"))
				+ point;
		if (request.getParameter("exp") != "") {
			exp = Integer.parseInt(request.getParameter("exp"));
		} else if (request.getAttribute("exp") != "") {
			exp = (Integer) request.getAttribute("exp");
		}
		int afterExp = mdao.findExp((String) request.getAttribute("userId"))
				+ exp;
		
		mdao.updatePoint((String) request.getAttribute("userId"), afterPoint);
		mdao.addPointLog((String) request.getAttribute("userId"), String.valueOf(point), String.valueOf(afterPoint),  new Timestamp(new Date().getTime()));
		mdao.updateExp((String) request.getAttribute("userId"), afterExp);
		request.setAttribute("totalPoint", afterPoint);
		request.setAttribute("point", point);
		request.setAttribute("totalExp", afterExp);
		request.setAttribute("exp", exp);

		return getNextPage();
	}*/

}
