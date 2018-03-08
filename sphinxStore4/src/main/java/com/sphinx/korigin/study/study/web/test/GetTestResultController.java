package com.sphinx.korigin.study.study.web.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetTestResultController {
	/*AnswerSheetService as = new AnswerSheetServiceImpl();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int showCount = 15; // 페이지당 보여줄 답안지 수
		if (request.getParameter("showCount") != null) {
			showCount = Integer.parseInt(request.getParameter("showCount"));
		} else {
			if (session.getAttribute("showCount") != null) {
				showCount = (int) session.getAttribute("showCount");
			}
		}
		session.setAttribute("showCount", showCount);
		String id = (String) session.getAttribute("userId");
		List<AnswerSheetForList> asheetList = null;
		int examListPageNum;
		int examListTotalPage = 0;
		Map<String, Float> myRecord = as.getMyRecord(id);
		request.setAttribute("myRecord", myRecord);
		if (request.getParameter("examListPageNum") == null) { // 첫 진입
			int totalAsheetNum = as.getNumberOfAnswerSheets(id); // 전체 답안지 수
			asheetList = as.findBriefSheetsOfMember(id, 0, showCount);  답안지 짧막정보리스트 저장(첫페이지용)
			examListTotalPage = totalAsheetNum / showCount
					+ (totalAsheetNum % showCount != 0 ? 1 : 0); // 전체 페이지 수 할당
			examListPageNum = 1; // 현재 페이지 번호 1로 할당
			session.setAttribute("asheets", asheetList);
			session.setAttribute("examListTotalPage", examListTotalPage);
			request.setAttribute("examListPageNum", examListPageNum);
		} else {
			examListTotalPage = (Integer) session
					.getAttribute("examListTotalPage");
			examListPageNum = Math.round(Float
					.parseFloat((request.getParameter("examListPageNum"))));
			asheetList = as.findBriefSheetsOfMember(id,
					(examListPageNum - 1) * showCount, showCount);
			request.setAttribute("examListPageNum", examListPageNum);
			session.setAttribute("asheets", asheetList);
		}
		// 답안지 다 가져오자
		return getNextPage();
	}*/

}
