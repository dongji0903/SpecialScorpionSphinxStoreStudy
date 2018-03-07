package com.sphinx.korigin.study.board.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadFile {

	/*@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		ServletContext context = request.getServletContext();

		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 100 * 1024 * 1024;

		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, path, sizeLimit, encType,
					new DefaultFileRenamePolicy());

			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			String title = multi.getParameter("title");
			String url = multi.getFilesystemName("url");
			String content = multi.getParameter("content");
			String catego = multi.getParameter("category");

			if (multi.getParameter("num") != null) {
				request.setAttribute("num", multi.getParameter("num"));
			}

			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("title", title);
			request.setAttribute("url", url);
			request.setAttribute("content", content);
			request.setAttribute("category", catego);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return getNextPage();
	}
*/
}
