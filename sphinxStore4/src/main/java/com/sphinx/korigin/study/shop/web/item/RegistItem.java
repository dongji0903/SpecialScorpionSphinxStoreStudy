package com.sphinx.korigin.study.shop.web.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.SaleManageDao;
import com.dug.dao.shop.StockManagementDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.dao.shop.impl.SaleManagementDaoImpl;
import com.dug.dao.shop.impl.StockManagementDaoImpl;
import com.dug.domain.shop.Item;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class RegistItem extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		ServletContext context = request.getServletContext();
		StockManagementDao stmd = StockManagementDaoImpl.getInstance();
		SaleManageDao smd = SaleManagementDaoImpl.getInstance();
		ItemDao id = ItemDaoImpl.getInstance();
		
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 100 * 1024 * 1024;

		MultipartRequest multi;
		try {
			multi = new MultipartRequest(request, path, sizeLimit, encType,
					new DefaultFileRenamePolicy());
			
			if (multi.getParameter("num") != null) {
				request.setAttribute("num", multi.getParameter("num"));
			}
			
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			int stock = Integer.parseInt(multi.getParameter("stock"));
			
			String url = multi.getFilesystemName("url");
			String content = multi.getParameter("content");
			String catego = multi.getParameter("category");
			
			String option1 = multi.getParameter("option1Val");
			String option2 = multi.getParameter("option2Val");		

			Item ivo = new Item();
			ivo.setName(name);
			ivo.setPrice(price);
			ivo.setUrl(url);
			ivo.setContent(content);
			ivo.setCategory(catego);
			ivo.setType1(option1);
			ivo.setType2(option2);
		
			String iId = id.insertItem(ivo);
			stmd.insertStock(iId, stock);
			smd.insertNumOfSale(iId);
			
			Logger logger = Logger.getLogger(this.getClass().getName());
			logger.info("itemMake: " + multi.getParameter("num"));
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		return getNextPage();

	}

}
