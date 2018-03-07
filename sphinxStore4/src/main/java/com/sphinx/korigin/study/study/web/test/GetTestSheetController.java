package com.sphinx.korigin.study.study.web.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetTestSheetController {
	/*TestSheetService ts = new TestSheetServiceImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("Test 도착");
		String sid = request.getParameter("sid");
		System.out.println("sid=" + sid);
		Sheet sheet = ts.findSheet(sid);
		System.out.println(sheet);
		System.out.println(sheet.getQuestionList().size());
		HttpSession session = request.getSession();
		session.removeAttribute("allSheets");
		session.setAttribute("sheet", sheet);
		return getNextPage();
	}*/
}
