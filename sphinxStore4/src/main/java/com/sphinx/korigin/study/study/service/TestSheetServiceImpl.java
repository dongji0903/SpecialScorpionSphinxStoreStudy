package com.sphinx.korigin.study.study.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.study.category.dao.*;
import com.sphinx.korigin.study.category.domain.Category;
import com.sphinx.korigin.study.study.dao.etc.*;
import com.sphinx.korigin.study.study.dao.exam.*;
import com.sphinx.korigin.study.study.dao.question.*;
import com.sphinx.korigin.study.study.dao.solution.*;
import com.sphinx.korigin.study.study.domain.exam.*;
import com.sphinx.korigin.study.study.domain.question.*;
import com.sphinx.korigin.study.study.domain.solution.*;

/**
 * 이 안에 모든게 있다.
 * 
 * @author 이광민
 *
 */
@Service("TestSheetService")
public class TestSheetServiceImpl implements TestSheetService {
	// 너무많다 분할이 필요하다
	@Autowired
	private QuestionDao questionDao ;
	@Autowired
	private QuestionCatDao questionCatDao ;
	@Autowired
	private StudyCategoryDao studyCategoryDao;
	@Autowired
	private SheetDao sheetDao ;
	@Autowired
	private SheetQuestionDao sheetQuestionDao ;
	@Autowired
	private DistractorDao distractorDao ;
	@Autowired
	private SolutionDao solutionDao ;
	@Autowired
	private SheetFormDao sheetFormDao ;
	@Autowired
	private GroupQuestionDao groupQuestionDao;
	@Autowired
	private ExamFormDao examFormDao ;
	@Autowired
	private JongryuDao jongryuDao;
	@Autowired
	private YoohyongDao yoohyongDao;
	@Autowired
	private YeongyoeckDao yeongyoeckDao;
	// 문제지나 문제 등록 및 불러오기 하는 서비스.

	public List<Category> getAllChildren(Category c) {
		Map<String, Category> categoryMap = studyCategoryDao.findAllCategory();
		List<Category> children = new ArrayList<>();
		if (c.getChildren() != null && !c.getChildren().isEmpty()) {
			for (String s : c.getChildren()) {
				Category sc = categoryMap.get(s);
				children.addAll(getAllChildren(sc));
			}
		}
		children.add(c);
		children.sort(null);
		return children;
	}

	private List<String> findQidList(Category c) { // 이건 트레이닝용 기능이므로 문제순서도 섞는다.
		Map<String, Category> categoryMap = studyCategoryDao.findAllCategory();
		List<String> qidList = new ArrayList<>();
		List<String> subQidList = new ArrayList<>();
		Category realC = categoryMap.get(c.getCid());
		List<Category> subCategoryList = getAllChildren(realC);
		for (Category cc : subCategoryList) {
			subQidList = questionCatDao.findQidsOfCategory(cc.getCid());
			if (subQidList != null & !subQidList.isEmpty()) {
				for (String qid : subQidList) {
					if (!qidList.contains(qid)) {
						qidList.add(qid);
					}
				}
			}
		}
		Collections.shuffle(qidList);
		return qidList;
	}

	@Override
	public List<Question> findQuestionsOfCategory(Category c) { //
		List<Question> questionList = new ArrayList<>();
		List<String> qidList = new ArrayList<>();
		qidList = findQidList(c); // qid를 랜덤
		for (String qid : qidList) { // qid정보로 객체를 가져옴 //카테고리정보도 추가해줌
			Question q = questionDao.findQuestion(qid);
			List<String> cidList = questionCatDao.findCidsOfQuestion(qid);
			if (cidList != null && !cidList.isEmpty()) {
				List<Category> cList = new ArrayList<>();
				for (String s : cidList) {
					cList.add(studyCategoryDao.findCategory(s));
				}
				q.setCategories(cList);
			}
			questionList.add(q);
		}
		questionList = registRandomDistractors(questionList);
		return questionList;
	}

	@Override
	public List<Question> findQuestionsOfJYP(String jongryu, String yeongyoeck,
			String yoohyong) {
		List<Question> findQuestionsOfTYP = questionDao.findQuestions(jongryu,
				yeongyoeck, yoohyong);
		if (findQuestionsOfTYP != null && !findQuestionsOfTYP.isEmpty()) {
			for (Question q : findQuestionsOfTYP) {
				int index = findQuestionsOfTYP.indexOf(q);
				System.out.println(q);
				if (q.getQtype().equals("o")) {
					ObjectiveQuestion oq = (ObjectiveQuestion) q;
					List<Distractor> distractors = distractorDao
							.findAllDistractors(oq.getQid());
					oq.setDistractorList(distractors);
					findQuestionsOfTYP.set(index, oq);
				} else {
					SubjectiveQuestion sq = (SubjectiveQuestion) q;
					findQuestionsOfTYP.set(index, sq);
				}
			}
		}
		return findQuestionsOfTYP;
	}

	@Override
	public List<Question> findQuestionsOfCategory(Category c,
			List<String> selectQid) {
		Map<String, Category> categoryMap = studyCategoryDao.findAllCategory();
		List<Question> questionList = new ArrayList<Question>();
		List<String> qidList = new ArrayList<String>();
		Category realC = categoryMap.get(c.getCid());
		qidList = findQidList(realC);
		// 중복된 qid를 제거
		for (String selectQ : selectQid) {
			if (qidList.contains(selectQ)) {
				qidList.remove(selectQ);
			}
		}
		for (String qid : qidList) { // qid정보로 객체를 가져옴 //카테고리정보도 추가해줌
			Question q = questionDao.findQuestion(qid);
			List<String> cidList = questionCatDao.findCidsOfQuestion(qid);
			if (cidList != null && !cidList.isEmpty()) {
				List<Category> cList = new ArrayList<>();
				for (String s : cidList) {
					cList.add(studyCategoryDao.findCategory(s));
				}
				q.setCategories(cList);
			}
			questionList.add(q);
		}
		questionList = registRandomDistractors(questionList);
		return questionList;
	}

	@Override
	public List<Question> findQuestionsOfCategory(Category c, int count) {
		List<String> qidList = new ArrayList<>();
		List<Question> questionList = new ArrayList<>();
		Map<String, Category> categoryMap = studyCategoryDao.findAllCategory();

		if (c != null && c.getCid() != null) { // 주어진 카테고리가 포함하는 모든 카테고리에 해당되는
												// qid 불러옴
			Category realC = categoryMap.get(c.getCid());
			qidList = findQidList(realC);
			if (qidList.size() < count) {
				System.out.println("문제가 그만큼 없음:최대=" + qidList.size());
				return null;
			}

			for (int i = 0; i < count; i++) { // qid정보로 객체를 가져옴 //카테고리정보도 추가해줌
				Question q = questionDao.findQuestion(qidList.get(i));
				List<String> cidList = questionCatDao.findCidsOfQuestion(qidList.get(i));
				if (cidList != null && !cidList.isEmpty()) {
					List<Category> cList = new ArrayList<>();
					for (String s : cidList) {
						cList.add(studyCategoryDao.findCategory(s));
					}
					q.setCategories(cList);
				}
				questionList.add(q);
			}
		} else {
			System.out.println("카테고리 입력바람");
			return null;
		}
		questionList = registRandomDistractors(questionList);
		return questionList;
	}

	private List<Question> registRandomDistractors(List<Question> questionList) {
		for (Question q : questionList) { // 객관식의 경우 보기를 할당해줌
			int index = questionList.indexOf(q);
			if (q instanceof ObjectiveQuestion) {
				ObjectiveQuestion objq = (ObjectiveQuestion) q;
				List<Distractor> distractorList = distractorDao
						.findAllDistractors(q.getQid());
				Collections.shuffle(distractorList);
				objq.setDistractorList(distractorList);
				questionList.set(index, objq);
			}
		}
		return questionList;
	}
	private List<Question> registDistractors(List<Question> questionList) {
		for (Question q : questionList) { // 객관식의 경우 보기를 할당해줌
			int index = questionList.indexOf(q);
			if (q instanceof ObjectiveQuestion) {
				ObjectiveQuestion objq = (ObjectiveQuestion) q;
				List<Distractor> distractorList = distractorDao
						.findAllDistractors(q.getQid());
				objq.setDistractorList(distractorList);
				questionList.set(index, objq);
			}
		}
		return questionList;
	}

	@Override
	public String createQuestion(Question question, Solution solution) {
		String qid = null;
		if (question != null) {
			qid = questionDao.createQuestion(question); // 문제부터 DB등록, qid 얻음. 주관식은 이게 끝
			List<Category> categories = question.getCategories();
			for (Category c : categories) {
				questionCatDao.addLink(qid, c.getCid()); // 카테고리 관계 등록// qid는 위에서 얻고 cid는
												// question정보로부터 받음
			}
			if (question instanceof ObjectiveQuestion) { // 객관식일때 추가작업
				ObjectiveQuestion oQuestion = (ObjectiveQuestion) question;
				List<Distractor> distractors = oQuestion.getDistractorList();
				for (Distractor d : distractors) {
					d.setQid(qid);
					distractorDao.createDistractor(d); // 문제의 보기 DB등록
				}
			}
		}
		if (solution != null) {
			solution.setQid(qid); // 위에서 만들어진 qid를 할당
			if (solution instanceof ObjectiveSolution) {
				List<Distractor> findD = distractorDao.findAllDistractors(qid);
				List<Distractor> newDList = new ArrayList<>();
				for (Distractor d : findD) {
					if (((ObjectiveSolution) solution).getDList()
							.contains(d)) {
						newDList.add(d); // DB에 등록된 문제의 보기 중 solution객체가 가진 보기
											// 내용과 같은 것을 추려냄
					}
				}
				((ObjectiveSolution) solution).setDList(newDList);
				solutionDao.createSolution(solution);
			}
			if (solution instanceof SubjectiveSolution) {
				solutionDao.createSolution(solution);
			}
		}
		return qid;
	}

	@Override
	public List<Sheet> findAllSheets(String formal) {
		List<Sheet> sheetList=null;
		if(formal.equalsIgnoreCase("N")) {
			sheetList = sheetDao.findAllInformalSheets();
		}else {
			sheetList = sheetDao.findAllFormalSheets();
			
		}
		if (!sheetList.isEmpty()) {
			for (Sheet sheet : sheetList) {
				int sIndex = sheetList.indexOf(sheet);
				String sid = sheet.getSid();
				List<String> qidList = sheetQuestionDao.findQidsOfSheet(sid);
				List<Question> qList = new ArrayList<>();
				if (!qidList.isEmpty()) {
					for (String qid : qidList) {
						Question q = questionDao.findQuestion(qid);
						qList.add(q);
					}
					qList = registRandomDistractors(qList);
					sheet.setQuestionList(qList);
				}
				sheetList.set(sIndex, sheet);
			}
		}
		return sheetList;
	}

	@Override
	public Sheet findSheet(String sid) {
		Sheet sheet = sheetDao.findSheet(sid);
		List<Question> qList = new ArrayList<>();
		for (String qid : sheetQuestionDao.findQidsOfSheet(sid)) {
			Question q = questionDao.findQuestion(qid);
			qList.add(q);
		}
		if (sheet instanceof ExamSheet) {
			String eid = sheetFormDao.findFormIdOfSheet(sid);
			ExamForm examform = examFormDao.findExamForm(eid);
			List<String> gidList = examFormDao.findGidList(eid);
			List<GroupQuestion> gList = new ArrayList<>();
			for (String gid : gidList) {
				gList.add(groupQuestionDao.findGroupQuestion(gid));
			}
			examform.setgList(gList);
			ExamSheet examSheet=(ExamSheet)sheet;
			examSheet.setExamForm(examform);
			qList = registRandomDistractors(qList);
			examSheet.setQuestionList(qList);
			return examSheet;
		}else {
		qList = registRandomDistractors(qList);
		sheet.setQuestionList(qList);
		return sheet;
		}
	}

	@Override
	public void modifySheet(Sheet s) {
		sheetDao.updateSheet(s);

	}

	@Override
	public void modifyQuestion(Question q) {
		questionDao.updateQuestion(q);
	}

	@Override
	public List<Question> checkGetQuestions(List<Question> findQ,
			Map<String, List<Question>> sheetQ, String yoohyong) {
		if (sheetQ != null && !sheetQ.isEmpty()) {
			List<Question> list = sheetQ.get(yoohyong);
			if (list != null && !list.isEmpty()) {
				for (Question q : list) {
					for (int i = 0; i < list.size(); i++) {
						if (findQ.get(i).getQid().equals(q.getQid())) {
							findQ.remove(findQ.get(i));
						}
					}
				}
				return findQ;
			} else {
				return findQ;
			}
		} else {
			return findQ;
		}
	}

	@Override
	public void createSheet(Sheet s) {
		String sid = sheetDao.createSheet(s);
		List<Question> qList = s.getQuestionList();
		System.out.println(qList);
		if (qList != null && !qList.isEmpty()) {
			for (Question q : qList) {
				System.out.println(sid);
				System.out.println(q.getQid());
				sheetQuestionDao.addLink(sid, q.getQid());
			}
		}
		if (s instanceof ExamSheet) {
			ExamForm examform = ((ExamSheet) s).getExamForm();
			System.out.println(examform);
			sheetFormDao.addLink(sid, examform.getEid());
		}
	}

	/**
	 * 공통질문 db입력
	 * 
	 * @author 이광민
	 *
	 */
	@Override
	public void createGroupQuestion(GroupQuestion groupQuestion) {
		groupQuestionDao.createTestForm(groupQuestion);
	}

	@Override
	public GroupQuestion getGroupQuestion(String fid) {
		return groupQuestionDao.findGroupQuestion(fid);
	}

	/**
	 * 특정 종류의 시험지 양식 db입력
	 * 
	 */
	@Override
	public void createExamForm(ExamForm examForm) {
		examFormDao.createExamForm(examForm);
	}

	@Override
	public ExamForm getExamFormByJongryu(String jongryu) {
		ExamForm examForm = examFormDao.findExamFormByJ(jongryu);
		if (examForm != null) {
			List<String> gidList = examFormDao.findGidList(examForm.getEid());
			List<GroupQuestion> gList = new ArrayList<>();
			for (String gid : gidList) {
				gList.add(groupQuestionDao.findGroupQuestion(gid));
			}
			examForm.setgList(gList);
		}
		return examForm;
	}

	@Override
	public Question getQuestion(String qid) {
		return questionDao.findQuestion(qid);
	}
	@Override
	public List<String> getAllYeongyoeck() {
		return yeongyoeckDao.getAllYeongyoeck();
	}
	@Override
	public void addYeongyoeck(String s) {
		yeongyoeckDao.addYeongyoeck(s);
	}
	@Override
	public List<String> getAllYoohyong() {
		return yoohyongDao.getAllYoohyong();
	}
	@Override
	public void addYoohyong(String s) {
		yoohyongDao.addYoohyong(s);
	}
	@Override
	public List<String> getAllJongryu() {
		return jongryuDao.getAllJongryu();
	}
	@Override
	public void addJongryu(String s) {
		jongryuDao.addJongryu(s);
	}
	@Override
	public List<Question> findQuestionsForSolution(String sid) {
		List<Question> qList = new ArrayList<>();
		for (String qid : sheetQuestionDao.findQidsOfSheet(sid)) {
			Question q = questionDao.findQuestion(qid);
			qList.add(q);
		}
		
		qList = registDistractors(qList);
		return qList;
		
	}
	@Override
	public List<GroupQuestion> getGroupQuestionsByYY(String yeongyoeck,
			String yoohyong) {
		List<GroupQuestion> gList=groupQuestionDao.findGroupQuestionsByYY(yeongyoeck, yoohyong);
		return gList;
	}
	@Override
	public void createExamForm(String jongryu,String coverUrl, String[] gidArr) {
		ExamForm examForm=new ExamForm();
		List<GroupQuestion> gList=new ArrayList<>();
		for(String gid:gidArr) {
			gList.add(groupQuestionDao.findGroupQuestion(gid));
		}
		examForm.setJongryu(jongryu);
		examForm.setCoverUrl(coverUrl);
		examForm.setgList(gList);
		examFormDao.createExamForm(examForm);
	}

}
