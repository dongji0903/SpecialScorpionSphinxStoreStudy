package com.sphinx.beautea.common.web.controller.admin.page.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChoiceBoardController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String choiceBoard() {
		
		return "admin/page/mypage/admin_board";
	}
}
