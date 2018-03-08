package com.sphinx.korigin.study.study.web.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetTestDetailController {
	/*AnswerSheetService as=new AnswerSheetServiceImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		int pageNum=(int) Float.parseFloat(request.getParameter("pageNo"));
		int listNum=Integer.parseInt(request.getParameter("num"));
		@SuppressWarnings("unchecked")
		List<AnswerSheetForList> asheetList=(List<AnswerSheetForList>) session.getAttribute("asheets");
		
		request.setAttribute("pageNo", pageNum);
		request.setAttribute("num", listNum);
		String asid=asheetList.get(asheetList.size()-listNum).getAsid();
		AnswerSheet asheet=as.findAsheet(asid);
		SheetTestRecord sheetRecord=as.getSheetRecord(asheet.getSid());
		request.setAttribute("asheet", asheet);
		request.setAttribute("sheetRecord", sheetRecord);
		
		
		return getNextPage();
	}*/

}
