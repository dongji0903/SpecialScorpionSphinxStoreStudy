package com.sphinx.korigin.study.study.dao.exam;

import java.util.List;

import com.sphinx.korigin.study.study.domain.exam.ExamForm;

public interface ExamFormDao {
	public void createExamForm(ExamForm examForm);

	public ExamForm findExamForm(String eid);

	public ExamForm findExamFormByJ(String jongryu);

	public List<String> findGidList(String eid);
}
