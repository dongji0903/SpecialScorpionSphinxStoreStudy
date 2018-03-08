package com.sphinx.beautea.product.web.controller.admin.add;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sphinx.beautea.category.domain.LinkInC;
import com.sphinx.beautea.category.service.LinkInCService;
import com.sphinx.beautea.common.primary.CreatePrimary;
import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.domain.Product;
import com.sphinx.beautea.product.service.OptionService;
import com.sphinx.beautea.product.service.ProductService;

@Controller
public class CreateSucProduct {
	@Autowired
	ProductService productService;
	@Autowired
	OptionService optionService;
	@Autowired
	LinkInCService linkInCService;

	@RequestMapping(value = "/admin/product/createproduct", method = RequestMethod.GET)
	public String moveBefore() {
		return "redirect:/admin/product/add";
	}

	@RequestMapping(value = "/admin/product/createproduct", method = RequestMethod.POST)
	public String mybatistest(MultipartHttpServletRequest request, 
			@ModelAttribute Product product, @RequestParam("categoryId") String id) throws IOException {
		
		String[] optionName = request.getParameterValues("optionName");
		String[] chkOption = request.getParameterValues("chkOption");
		
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
			List<Option> optionlist = new ArrayList<>();
			
			CreatePrimary primary = CreatePrimary.getInstance();
			Long key = Long.parseLong(primary.createPrimaryKey());
			
			for (int i = 0; i < optionName.length; i++) {
				Option option = new Option();

				key++;
				option.setOptionId(""+ key);
				option.setOptionName(optionName[i]);
				
				Map<String, Double> optionValue = new HashMap<>();
				String[] detailoption = request.getParameterValues("detailoption" + chkOption[i]);
				String[] amounts = request.getParameterValues("amount" + chkOption[i]);
				if (detailoption != null && detailoption.length >= 1) {
					for (int x = 0; x < detailoption.length; x++) {
						optionValue.put(detailoption[x], Double.parseDouble(amounts[x]));
					}
				}
				option.setOptionValueMap(optionValue);
				optionlist.add(option);
			}
			
			product.setOptionList(optionlist); //상품 완성
			product.setProductId(productService.addProduct(product));
			
			
			for (Option o : product.getOptionList()) {
				System.out.println(o.getOptionId());
				optionService.addOption(o, product.getProductId());
			}
			
			LinkInC link = new LinkInC();
			link.setCategoryId(id);
			link.setProductId(product.getProductId());
			linkInCService.addLinkInC(link);
			
			System.out.println("상품 등록 완료.");
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

		return "redirect:/admin";
	}
}
