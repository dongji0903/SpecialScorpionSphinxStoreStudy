package com.sphinx.korigin.study.study.domain.question;

import java.util.List;

import com.sphinx.korigin.study.category.domain.Category;

public class SubjectiveQuestion extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3871839461246287099L;

	public SubjectiveQuestion(String txt, double point, String fileUrl,
			String fileType, String qType, String source,
			List<Category> categories) {
		super(txt, point, fileUrl, fileType, qType, source, categories);
		// TODO Auto-generated constructor stub
	}

	public SubjectiveQuestion(String qid, String text, double score,
			String fileUrl, String fileType, String qtype, String source,
			List<Category> categories) {
		super(qid, text, score, fileUrl, fileType, qtype, source, categories);
		// TODO Auto-generated constructor stub
	}

	public SubjectiveQuestion(String text, double score, String fileUrl,
			String fileType, String string, String source, Object object) {
		super(text, score, fileUrl, fileType);
	}

	@Override
	public String toString() {
		return "SubjectiveQuestion " + super.toString() + "]";
	}

}
