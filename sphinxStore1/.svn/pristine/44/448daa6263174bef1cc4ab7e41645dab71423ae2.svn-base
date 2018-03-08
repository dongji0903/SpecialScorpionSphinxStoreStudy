package com.sphinx.beautea.common.domain;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

	private int pages = 10; //페이지 숫자 보여주는거 한덩어리
	private int amount = 12; //목록에 뿌려줄 게시글 갯수
	private int maxPage = 1; // 마지막 페이지

	public List<Integer> getPages(int count, int page) { 
		int middle = 1; //페이지의 중간 숫자
		if(pages % 2 == 0) {
			middle = pages/2;
		} else {
			middle = pages/2 + 1;
		}
		
		List<Integer> pageList = new ArrayList<>();
		if(getMaxPage(count) <= pages) { //page가 pages개 이하일 경우
			pages = getMaxPage(count);
			for(int c = 1; c <= getMaxPage(count); c++) {
				pageList.add(c);
			} 
		} else { //page가 pages초과일 경우
			if(page <= middle) {
				for(int c = 1; c <= pages; c++) {
					pageList.add(c);
				}
			} else {
				if(pages % 2 == 0) {
					if(page + middle > getMaxPage(count)) {
						for(int c = page - (middle - 1); c <= getMaxPage(count); c++) {
							pageList.add(c);
						}
					} else {
						for(int c = page - (middle - 1); c <= page + middle; c++) {
							pageList.add(c);
						}
					}
					
				} else {
					if(page + (middle - 1) > getMaxPage(count)) {
						for(int c = page - (middle - 1); c <= getMaxPage(count); c++) {
							pageList.add(c);
						}
					} else {
						for(int c = page - (middle - 1); c <= page + (middle - 1); c++) {
							pageList.add(c);
						}
					}
				}
			}
		}
		return pageList;
	}
	
	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getMaxPage(int count) { 
		if(count % amount == 0) {
			maxPage = count/amount;
		} else {
			maxPage = count/amount + 1;
		}
		return maxPage;
	}
	
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	
}
