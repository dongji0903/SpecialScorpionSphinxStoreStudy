package com.sphinx.korigin.study.study.dao.answer;

import java.util.List;
import java.util.Map;

import com.sphinx.korigin.study.study.domain.answer.AnswerSheet;
import com.sphinx.korigin.study.study.domain.answer.SheetTestRecord;

public interface AnswerSheetDao {

	String createAnswerSheet(AnswerSheet as);

	List<AnswerSheet> findAllAnswerSheets();

	AnswerSheet findAnswerSheet(String asid);

	void updateAnswerSheet(AnswerSheet as);

	void deleteAnswerSheet(String asid);

	List<AnswerSheet> findAnswerSheetsForListOfMember(String id, int skip,
			int count);

	int getNumberOfAnswerSheets(String id);

	SheetTestRecord getSheetRecord(String sid);

	Map<String, Object> getMyRecord(String id);

}
