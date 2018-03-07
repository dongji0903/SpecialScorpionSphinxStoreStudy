package com.sphinx.korigin.study.study.dao.question;

import java.util.List;

import com.sphinx.korigin.study.study.domain.question.GroupQuestion;


public interface GroupQuestionDao {
	void createTestForm(GroupQuestion form);

	List<GroupQuestion> findGroupQuestionByJYY(String jongryu,String yeongyoeck,String yoohyong);

	GroupQuestion findGroupQuestion(String gid);

	List<GroupQuestion> findGroupQuestionsByYY(String yeongyoeck,
			String yoohyong);
}
