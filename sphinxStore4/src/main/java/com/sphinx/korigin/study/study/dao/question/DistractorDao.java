package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

import com.sphinx.korigin.study.study.domain.question.Distractor;

public interface DistractorDao {

	void createDistractor(Distractor d);
	
	List<Distractor> findAllDistractors();
	
	List<Distractor> findAllDistractors(String qid);
	
	Distractor findDistractor(String did);
	
	void updateDistractor(Distractor d);
	
	void deleteDistractor(String did);
	
	
}
