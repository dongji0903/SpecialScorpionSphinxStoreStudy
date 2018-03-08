package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

public interface SheetQuestionDao {

	public void addLink(String sid, String qid);

	public void removeLink(String sid, String qid);

	public List<String> findQidsOfSheet(String sid);

	public List<Integer> findSheetsOfQuestion(String qid);
}
