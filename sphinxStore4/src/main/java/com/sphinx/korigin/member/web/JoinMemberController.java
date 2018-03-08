package com.sphinx.korigin.member.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import com.sphinx.korigin.member.domain.Member;

@Controller
@RequestMapping(value = "/member/join")
public class JoinMemberController implements ApplicationContextAware {
	@Autowired
	private WebApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String showJoinPage(Model m) {
		m.addAttribute("url", "/WEB-INF/views/korigin/study/member/login/joinMembership.jsp");
		return "korigin/study/form/main_Form";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String joinMembership(@ModelAttribute Member member) {
		return "korigin/study/form/main_Form";
	}

	@ModelAttribute("nationalCodes")
	public Map<String, String> getNationalCode() {
		Map<String, String> nationalCodeMap = new TreeMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					new File(context.getServletContext().getRealPath("/resources/"), "nationalCode.txt")));
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

	/*
	 * MemberDao md = MemberDaojdbcImpl.getInstance();
	 * 
	 * @Override public String execute(HttpServletRequest request,
	 * HttpServletResponse response) { Member user = new
	 * Member(request.getParameter("userId")); String user_Email =
	 * request.getParameter("userEmail"); String user_Phone =
	 * request.getParameter("userPhoneNum0") + request.getParameter("userPhoneNum1")
	 * + request.getParameter("userPhoneNum2"); String[] user_hobbies =
	 * request.getParameterValues("userHobby"); if(user_hobbies!=null) { int count =
	 * user_hobbies.length - 1; user_hobbies[count] =
	 * request.getParameter("userOtherHobby"); String hobbies = ""; for (String
	 * hobby : user_hobbies) { hobbies += (hobby + "/"); }
	 * 
	 * user.setHobbies(hobbies); }
	 * user.setPassword(request.getParameter("userPass"));
	 * user.setNickName(request.getParameter("nickName"));
	 * user.setName(request.getParameter("userName"));
	 * user.setBirth(request.getParameter("userBirth"));
	 * user.setAddress(request.getParameter("userAddr")); user.setEmail(user_Email);
	 * user.setPhonenumber(user_Phone);
	 * 
	 * 
	 * md.joinMember(user);
	 * 
	 * return getNextPage(); }
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
}
