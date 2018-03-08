package jvx330.mod007;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러로 인식
public class HelloController {
	@RequestMapping("/mod007/sayHello")
	public ModelAndView sayHello() {
		String greeting = "Hello. 스프링MVC";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mod007/hello");
		mav.addObject("greeting", greeting);
		
		return mav;
	}
}
