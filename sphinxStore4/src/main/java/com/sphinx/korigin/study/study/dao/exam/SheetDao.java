package com.sphinx.korigin.study.study.dao.exam;

import java.util.List;

import com.sphinx.korigin.study.study.domain.exam.Sheet;

public interface SheetDao {

	public String createSheet(Sheet s);

	public List<Sheet> findAllInformalSheets(); // 형식이 없는 시험만 가져온다.

	public List<Sheet> findAllFormalSheets(); // 형식을 갖춘 시험만 가져온다.

	public Sheet findSheet(String sid);

	public List<Sheet> findSheets(String examiner);

	public void updateSheet(Sheet s);

	public int getNumberOfSheets();
}
