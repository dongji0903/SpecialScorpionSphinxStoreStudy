package com.sphinx.korigin.study.study.web.exam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RegistExamFormController {

	/*TestSheetService ts=new TestSheetServiceImpl();
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String path = request.getServletContext().getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 100 * 1024 * 1024;
		System.out.println("저장경로:" + path);
		MultipartRequest multi;
		try {
			multi=new MultipartRequest(request, path, sizeLimit, encType,new DefaultFileRenamePolicy());
			String jongryu=multi.getParameter("jongryu");
			String[] groupQuestionIds=multi.getParameterValues("gnum");
			String coverUrl=multi.getFilesystemName("coverFile");
			ts.createExamForm(jongryu,coverUrl, groupQuestionIds);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getNextPage();
	}
*/
}
