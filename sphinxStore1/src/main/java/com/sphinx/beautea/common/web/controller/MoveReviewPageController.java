package com.sphinx.beautea.common.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoveReviewPageController {
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String movePage() {
		return "index-3";
	}
}
