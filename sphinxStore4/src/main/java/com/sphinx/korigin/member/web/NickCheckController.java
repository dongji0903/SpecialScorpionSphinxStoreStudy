package com.sphinx.korigin.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.member.service.MemberService;
@Controller
public class NickCheckController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/nickCheck",method=RequestMethod.GET)
	public String nickCheck(Model m,@RequestParam("nickName")String nickName) {
		if(memberService.nickCheck(nickName)) {
			m.addAttribute("result", 1);
		}else {
			m.addAttribute("result", -1);
		}
		m.addAttribute("nickName", nickName);
		return "korigin/study/member/login/nickCheck";
	}
}
