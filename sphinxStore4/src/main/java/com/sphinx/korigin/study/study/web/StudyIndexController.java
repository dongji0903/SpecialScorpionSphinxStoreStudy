package com.sphinx.korigin.study.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudyIndexController {
	@RequestMapping(value="/study/index",method=RequestMethod.GET)
	public String studyInitialView(Model m) {
		m.addAttribute("url", "/WEB-INF/views/korigin/study/study/studyIndex.jsp");
		return "korigin/study/form/main_Form";
	}
}
