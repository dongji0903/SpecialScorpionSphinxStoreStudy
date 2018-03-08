package practice.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import practice.service.PracticeService;

@Controller
public class SayHello {
	@Autowired
	private PracticeService practiceService;
	
	@RequestMapping("/sayhello")
	public ModelAndView sayHello() {
		ModelAndView mav = new ModelAndView();
		String s = practiceService.SayHello("나는 케익이 너무너무 좋아!!");
		mav.addObject("say", s);
		mav.setViewName("mod007/sayhw");
		
		return mav;
	}
	
}
