package com.sphinx.beautea.product.web.controller.admin.edit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sphinx.beautea.category.domain.Category;
import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.category.service.CategoryService;
import com.sphinx.beautea.category.service.LinkInCService;
import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.OptionService;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class EditProductController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	OptionService optionService;
	@Autowired
	LinkInCService linkService;
	
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request) {
		String productId = request.getParameter("productId");
		String categoryId = request.getParameter("categoryId");

		@SuppressWarnings("unchecked")
		List<Category> root_List = (List<Category>) request.getServletContext().getAttribute("rootcate");
		@SuppressWarnings("unchecked")
		Map<String, Category> AllCate = (Map<String, Category>)request.getServletContext().getAttribute("allcate");

		Product product = productService.getProductById(productId);
		Category category = categoryService.getCategoryById(categoryId);
		
		List<Category> category_list = new ArrayList<>();
		Map<String, List<Category>> parent_list = new HashMap<>();
		
		for (Category c : root_List) {
			category_list.addAll(c.getSubCategoryList(c));
		}
		
		for (Category c : category_list) {
			parent_list.put(c.getCategoryId(), getParents(c, AllCate));
		}
		
		
		request.setAttribute("category", category);
		request.setAttribute("product", product);
		request.setAttribute("categoryList", category_list);
		request.setAttribute("parents", parent_list);
		
		return "admin/product/edit/edit_product";
	}
	
	
	
	
	public List<Category> getParents(Category cate, Map<String, Category> AllCate) {
		List<Category> parents = categoryService.getParentCategoryListById(cate.getCategoryId(), AllCate);
		return parents;
	}
	
	
	
	
	
	
	

	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
	public String editComplete(MultipartHttpServletRequest request) throws IOException{
		String productId = request.getParameter("productId");
		String categoryId = request.getParameter("categoryId");
		String originCategoryId = request.getParameter("originCategoryId");
		
		Product product = productService.getProductById(productId);
		List<String> filelist = new ArrayList<>();
		
		List<MultipartFile> files = request.getFiles("fileNm");
		FileOutputStream fos = null;
		
		try {
			for (MultipartFile file : files) {
				byte fileData[] = file.getBytes();
				
				String path = request.getServletContext().getRealPath("/resources/");
		    	final String filepath = path.replaceAll("/", "\\") + "img";
		    	
		    	String fileName = file.getOriginalFilename();
		    	//파일명이 중복될수 있으므로 밀리세컨드단위의 시간을 파일이름 앞에 붙여주자.
		    	fileName = System.currentTimeMillis() + "_" + fileName;
		    	filelist.add(fileName);
		    	//스트림에 담은후
				fos = new FileOutputStream(filepath + "\\" + fileName);
				//쏘세요.
				fos.write(fileData);
			}
			
			product.setFileName(filelist);
			
			
			//카테고리 수정시
			List<LinkInC> linkList = linkService.getLinkInCListByProductId(productId);
			if(!categoryId .equals(originCategoryId)) {
				for(LinkInC link : linkList) {
					LinkInC linkInC = link;
					if(link.getCategoryId().equals(originCategoryId)) {
						linkInC.setCategoryId(categoryId);
						linkService.updateLinkInC(linkInC);
						break;
					}
				}
			}
			
			String productName = request.getParameter("productName");
			String price = request.getParameter("price");
			String comment = request.getParameter("comment");
			String content = request.getParameter("content");
			
			product.setProductName(productName);
			product.setPrice(Double.parseDouble(price));
			product.setComment(comment);
			product.setContent(content);
			
			
			//옵션 설정
			String[] optionName = request.getParameterValues("optionName");
			String[] chkOption = request.getParameterValues("chkOption");
			
			
			List<Option> optionList = optionService.getOptionListByProductId(productId);
			if(chkOption.length == optionList.size()) {
				for(String chkStr : chkOption) {
					int chk = Integer.parseInt(chkStr);
					Option option = optionList.get(chk); 
					option.setOptionName(optionName[chk]);
					String[] optionValue = request.getParameterValues("detailoption" + chk);
					String[] addPriceStr = request.getParameterValues("amount" + chk);
					System.out.println(optionValue.length);
					Map<String, Double> valueMap = new HashMap<>();
					if(option.getOptionValueMap() != null) { //밸류가 있을 경우 삭제한 후 재등록하겠다.
						optionService.deleteOptionValue(option.getOptionId());
					}
					for(int i = 0; i < optionValue.length; i++) {
						double addPrice = Double.parseDouble(addPriceStr[i]);
						valueMap.put(optionValue[i], addPrice);
					}
					option.setOptionValueMap(valueMap);
					optionService.updateOption(option);
					optionList.add(option);
				}
			} else {
				for(Option o : optionList) {
					if(o.getOptionValueMap() != null) {
						optionService.deleteOptionValue(o.getOptionId());
					}
					optionService.deleteOption(o);
				}
				for(String chkStr : chkOption) {
					int chk = Integer.parseInt(chkStr);
					Option option = new Option();
					option.setOptionName(optionName[chk]);
					String[] optionValue = request.getParameterValues("detailoption" + chk);
					String[] addPriceStr = request.getParameterValues("amount" + chk);
					Map<String, Double> valueMap = new HashMap<>();
					for(int i = 0; i < optionValue.length; i++) {
						double addPrice = Double.parseDouble(addPriceStr[i]);
						valueMap.put(optionValue[i], addPrice);
					}
					option.setOptionValueMap(valueMap);
					optionService.addOption(option, productId);
					optionList.add(option);
				}
			}
			
			product.setOptionList(optionList);
			
			productService.updateProduct(product);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}

			}
		} // try end;

		
		return "redirect: /admin/product/edit/choiceproduct?categoryId=" + categoryId;
	}
}
