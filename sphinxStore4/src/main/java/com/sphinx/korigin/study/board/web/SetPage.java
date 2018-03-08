package com.sphinx.korigin.study.board.web;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetPage {
	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		BoardDao bdao = BoardDaoImpl.getInstance();

		String cate = null;
		if (request.getParameter("category") == null) {
			cate = (String) session.getAttribute("category");
		} else {
			cate = request.getParameter("category");
		}
		
		int boardSize = 0;
		int setListHight = 12; // 화면에 보여줄 List의 열 셋팅
		int nowPage = 0; // 현제 페이지 수
		int offset; // DB에서 가져올때 시작 번호
		int count = 0; // DB에서 가져올때 갯수 세기
	
		
		List<Board> searchBoardList = new ArrayList<Board>();
		List<Board> adaptedBoardList = new ArrayList<Board>();

		if (request.getAttribute("searchBoardList") != null) {

			boardSize = searchBoardList.size();
		} else {
			boardSize = bdao.getMaxCount(cate);
		}

		if (request.getParameter("pageNumber") != null) {
			nowPage = Integer.parseInt(request.getParameter("pageNumber"));
		} else {
			nowPage = 1;
		}
		
		PageUtil p_Util = new PageUtil(setListHight,10,boardSize);

		if (nowPage == 1) {
			offset = 0;
			if (searchBoardList != null) {
				for (Board bvv : searchBoardList) {
					if (count > setListHight) {
						break;
					}
					adaptedBoardList.add(bvv);
					count++;
				}
			} 
		} else {
			offset = (nowPage - 1) * setListHight;
			if (searchBoardList != null) {
				for (Board bvv : searchBoardList) {
					if (count > setListHight * nowPage) {
						break;
					} else if (count > setListHight * (nowPage - 1)) {
						adaptedBoardList.add(bvv);
						count++;
					}
				}
			} 
		}

		if (searchBoardList.size() == 0||searchBoardList == null) {
			System.out.println("offset: " + offset);
			List<Board> boardList = bdao.adaptedBoardForPage(offset,
					setListHight, cate);
			request.setAttribute("boardList", boardList);

		} else {
			request.setAttribute("searchBoardList", adaptedBoardList);
		}
	

		request.setAttribute("nextBlock", p_Util.getNextBlock(nowPage));
		request.setAttribute("prevBlock", p_Util.getPrevBlock(nowPage));
		request.setAttribute("totalPageNum", p_Util.getTotalNumOfPage(boardSize));
		request.setAttribute("blockList", p_Util.getBlockList(nowPage));

		return getNextPage();

	}*/
}