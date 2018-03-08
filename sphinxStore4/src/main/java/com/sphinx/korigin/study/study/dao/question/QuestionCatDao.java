package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

public interface QuestionCatDao {

	public void addLink(String qid, String cid);
	
	public void removeLink(String qid,String cid);
	
	public List<String> findCidsOfQuestion(String qid);
	
	public List<String> findQidsOfCategory(String cid);
}
