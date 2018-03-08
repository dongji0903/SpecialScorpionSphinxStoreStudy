package com.sphinx.korigin.member.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetPointPage {

	/*MemberDao mdao = MemberDaojdbcImpl.getInstance();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		int listHight =
				12
				;
		int blockSize 
		=
				10
				;
		int offset = 0; // DB에서 가져올때 시작 번호
		
		int size = mdao.getMaxCount((String)request.getSession().getAttribute("userId"));
		int nowPage = 0
				;
		
		if (request.getParameter("pageNumber") != null) {
			nowPage = Integer.parseInt(request.getParameter("pageNumber"));
		} else {
			nowPage = 1;
		}
		
		
		PageUtil p_Util = new PageUtil(listHight,blockSize, size );
				
			offset = (nowPage - 1) * listHight;

			List<pointLog> pointList = mdao.getPageLogList(offset, listHight, (String)request.getSession().getAttribute("userId"));
			     request.setAttribute("pointLog", pointList);

		
		request.setAttribute("nextBlock", p_Util.getNextBlock(nowPage));
		request.setAttribute("prevBlock", p_Util.getPrevBlock(nowPage));
		request.setAttribute("totalPageNum", p_Util.getTotalNumOfPage(size));
		request.setAttribute("blockList", p_Util.getBlockList(nowPage));

		
		return getNextPage();
	}
*/
}
