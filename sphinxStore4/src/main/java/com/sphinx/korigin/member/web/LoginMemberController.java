package com.sphinx.korigin.member.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.sphinx.korigin.member.domain.Member;
import com.sphinx.korigin.member.service.MemberService;

@Controller
@SessionAttributes({"userId","userName","nickName","email","memberType"})
public class LoginMemberController implements ApplicationContextAware {
	/* set을 대신해줌 */
	@Autowired
	private MemberService memberService;
	@Autowired
	private WebApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}

	/** 로그인을 처리하는 메소드 */
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView loginCustomer(ModelAndView m,
			@RequestParam("UserId") String id,
			@RequestParam("Password") String pw,
			@RequestParam("idSave")String saveId,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("[LoginMemberController]:id="+id+",pass="+pw);
		Member member=memberService.login(id, pw);
		if (member==null) {
			m.addObject("idMsg", "아이디나 비밀번호를 확인해 주세요.");
			m.addObject("contents", "customer/membership/login.jsp");
			System.out.println("[LoginMemberController]:아이디나 비밀번호 오류");
		}else {
			System.out.println("로그인성공\n"+member);
			m.addObject("userId", id);
			m.addObject("userName", member.getName());
			m.addObject("nickName", member.getNickName());
			m.addObject("email", member.getEmail());
			m.addObject("memberType", member.getMemberType());
			if (saveId != null) {
				System.out.println("[LoginMemberController]아이디 쿠키저장");
				Cookie c = new Cookie("id", id);
				c.setMaxAge(3600 * 24 * 30);
				c.setPath("/");
				response.addCookie(c);
			}else {
				Cookie[] cList = request.getCookies();
				for (Cookie c : cList) {
					if (c.getName().equalsIgnoreCase("id")) {
						c.setMaxAge(0);
						c.setPath("/");
						response.addCookie(c);
					}
				}
			}
		}
		RedirectView view = new RedirectView("/Sphinx_Store");
		view.setExposeModelAttributes(false);
		m.setView(view);
		return m;
	}

	/** 로그인창을 뿌려주는 메소드 */
	@RequestMapping(value = "/customer/loginCustomer", method = RequestMethod.GET)
	public String loginCustomerView(Model m,
			@RequestParam("type") String type) {
		m.addAttribute("contents", "customer/membership/login.jsp");
		m.addAttribute(type);
		return "korigin/default";
	}

	@RequestMapping(value = "/customer/logout", method = RequestMethod.GET)
	public ModelAndView logoutCustomer(ModelAndView m, SessionStatus status) {
		status.setComplete();
		m.addObject("contents", "index.jsp");
		RedirectView view = new RedirectView("/Sphinx_Store");
		view.setExposeModelAttributes(false);
		m.setView(view);
		return m;
	}

	@ModelAttribute("nationalCodes")
	public Map<String, String> getNationalCode() {
		Map<String, String> nationalCodeMap = new TreeMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					context.getServletContext().getRealPath("/resources/"),
					"nationalCode.txt")));
			for (String line = br.readLine(); line != null;) {
				String code = line;
				String[] nationalCode = code.split(",");
				nationalCodeMap.put(nationalCode[1], nationalCode[0]);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nationalCodeMap;
	}

}
