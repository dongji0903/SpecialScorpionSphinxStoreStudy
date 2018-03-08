package com.sphinx.korigin.study.study.web.question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RegistQuestionController {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		TestSheetService ts = new TestSheetServiceImpl();

		@SuppressWarnings("unchecked")
		Map<String, ShoppingCategory> categoryMap = (Map<String, ShoppingCategory>) request
				.getServletContext().getAttribute("categoryMap");
		List<ShoppingCategory> categories = new ArrayList<>();
		String path = request.getServletContext().getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 100 * 1024 * 1024;
		System.out.println("저장경로:" + path);
		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, path, sizeLimit, encType,
					new DefaultFileRenamePolicy());

			String qType = multi.getParameter("Qtype");
			String txt = multi.getParameter("Question");
			String fileUrl = multi.getFilesystemName("fileUrl");
			String fileType = multi.getParameter("fileType");
			double point = Double.parseDouble(multi.getParameter("Score"));
			String source = multi.getParameter("Source");
			String[] categoryIds = multi.getParameterValues("hiddenCategory");
			String sAns = multi.getParameter("ansTxt");
			String[] distList = multi.getParameterValues("dis");
			String[] truList = multi.getParameterValues("ansDis");
			String jongryu = multi.getParameter("jongryu");
			String yeongyoeck = multi.getParameter("yeongyoeck");
			String yoohyong = multi.getParameter("yoohyong");
			String solText=multi.getParameter("solText");
			String solFile=multi.getFilesystemName("solFile");

			for (String s : categoryIds) {
				categories.add(categoryMap.get(s));
			}
			if (qType.equals("o")) {
				List<Distractor> distractorList = new ArrayList<>();
				List<Distractor> trueDistractorList = new ArrayList<>();
				for (String s : distList) {
					distractorList.add(new Distractor(s));
				}
				for (String s : truList) {
					trueDistractorList
							.add(distractorList.get(Integer.parseInt(s)));
				}
				ObjectiveQuestion oq = new ObjectiveQuestion(txt, point,
						fileUrl, fileType, qType, source, categories,
						distractorList.size(), distractorList);
				oq.setJongryu(jongryu);
				oq.setYeongyoeck(yeongyoeck);
				oq.setYoohyong(yoohyong);
				ObjectiveSolution os = new ObjectiveSolution(
						trueDistractorList.size(), trueDistractorList);
				os.setText(solText);
				os.setFileUrl(solFile);
				ts.createQuestion(oq, os);
			} else {
				SubjectiveQuestion sq = new SubjectiveQuestion(txt, point,
						fileUrl, fileType, qType, source, categories);
				SubjectiveSolution ss = new SubjectiveSolution(sAns);
				sq.setJongryu(jongryu);
				sq.setYeongyoeck(yeongyoeck);
				sq.setYoohyong(yoohyong);
				ss.setText(solText);
				ss.setFileUrl(solFile);
				ts.createQuestion(sq, ss);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return getNextPage();
	}*/

}
