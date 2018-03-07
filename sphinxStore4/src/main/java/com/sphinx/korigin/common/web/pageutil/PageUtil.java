package com.sphinx.korigin.common.web.pageutil;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

	private int listHight = 12; // 화면에 보여줄 List의 열 셋팅
	private int block = 10; // 페이지를 묶음 셋팅(1~10 까지 1묶음)
	private int totalPageNum = 0;

	public PageUtil() {

	}

	public PageUtil(int listHight, int blockNum, int size) {
		this.listHight = listHight;
		this.block = blockNum;
		this.totalPageNum = getTotalNumOfPage(size);
	}

	public int getListHight() {
		return listHight;
	}

	public void setListHight(int setListHight) {
		this.listHight = setListHight;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int setBlock) {
		this.block = setBlock;
	}

	public int getTotalNumOfPage(int size) {
		int totalNum = 0;
		if (size % listHight == 0) {
			totalNum = (size / listHight);
		} else {
			totalNum = (size / listHight) + 1;
		}
		return totalNum;
	}

	public int getTotalNumOfBlock() {
		int numOfBlock = 0;
		if (totalPageNum % block == 0) {
			numOfBlock = (totalPageNum / block);
		} else {
			numOfBlock = (totalPageNum / block) + 1;
		}
		return numOfBlock;
	}

	public int getNextBlock(int nowPage) {
		int nextBlock;
		if (nowPage <= 10) {
			return 11;
		} else {
			String page = "" + nowPage;
			StringBuilder sb = new StringBuilder(page);
			if (sb.deleteCharAt(0).toString().equals("0")) {
				nextBlock = (nowPage + 1);
			} else {
				sb = new StringBuilder(page);
				sb.deleteCharAt(1);
				sb.append(1);
				nextBlock = Integer.parseInt(sb.toString()) + 10;
			}
			if (nextBlock > totalPageNum) {
				nextBlock = totalPageNum + 1;
			}
		}
		return nextBlock;
	}

	public int getPrevBlock(int nowPage) {
		int prevBlock;
		if (nowPage <= 10) {
			return 0;
		} else {
			String page = "" + nowPage;
			StringBuilder sb = new StringBuilder(page);
			if (sb.deleteCharAt(0).toString().equals("0")) {
				prevBlock = (nowPage - 10);
			} else {
				sb = new StringBuilder(page); // 앞자리수가 삭제됬기때문에 초기화
				sb.deleteCharAt(1);
				sb.append(0);
				prevBlock = Integer.parseInt(sb.toString());
			}
		}
		return prevBlock;
	}

	public List<Integer> getBlockList(int nowPage) {
		List<Integer> list = new ArrayList<>();
		for (int i = getPrevBlock(nowPage) + 1; i < getNextBlock(
				nowPage); i++) {
			if (i > totalPageNum) {
				break;
			}
			list.add(i);
		}
		return list;
	}
}
