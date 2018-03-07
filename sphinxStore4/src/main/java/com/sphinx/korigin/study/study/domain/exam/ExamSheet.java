package com.sphinx.korigin.study.study.domain.exam;

public class ExamSheet extends Sheet {
	
	private static final long serialVersionUID = 8974383743755924281L;
	private ExamForm examForm;

	public ExamForm getExamForm() {
		return examForm;
	}

	public void setExamForm(ExamForm examForm) {
		this.examForm = examForm;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+examForm.toString()+"]"+super.toString();
	}
	
	
}
