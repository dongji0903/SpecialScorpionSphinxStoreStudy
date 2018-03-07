package com.sphinx.korigin.study.study.web.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sphinx.korigin.study.study.service.TestSheetService;

@Controller
public class InitExamFormCommandController {

	/*TestSheetService ts = new TestSheetServiceImpl();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String jongryu = request.getParameter("jongryu");
		System.out.println(jongryu);
		request.setAttribute("jongryu", jongryu);
		if (jongryu != null) {
			ExamForm examForm = ts.getExamFormByJongryu(jongryu);
			request.setAttribute("examform", examForm);
		}
		return getNextPage();
	}*/
	@Autowired
	private TestSheetService testSheetService;
	@RequestMapping(value="/study/initExamForm",method=RequestMethod.GET)
	public String initExamForm(Model m,@RequestParam("jongryu")String jongryu) {
		
		return null;
	}
}
