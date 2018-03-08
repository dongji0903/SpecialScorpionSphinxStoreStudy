package com.sphinx.beautea.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.beautea.product.dao.OptionDao;
import com.sphinx.beautea.product.domain.Option;
import com.sphinx.beautea.product.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {
	@Autowired
	OptionDao optiondao;
	
	@Override
	public void addOption(Option option, String productId) {
		// TODO Auto-generated method stub
		optiondao.addOption(option, productId);
		
	}

	@Override
	public void updateOption(Option option) {
		// TODO Auto-generated method stub
		optiondao.updateOption(option);
	}

	@Override
	public void deleteOption(Option option) {
		// TODO Auto-generated method stub
		optiondao.deleteOption(option);
	}
	
	@Override
	public void deleteOptionValue(String optionId) {
		// TODO Auto-generated method stub
		optiondao.deleteOptionValue(optionId);
	}

	@Override
	public Option getOptionById(String optionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Option> getOptionListByProductId(String productId) {
		// TODO Auto-generated method stub
		return optiondao.getOptionListByProductId(productId);
	}

	@Override
	public List<Option> getDeleteOptionListByProductId(String productId) {
		// TODO Auto-generated method stub
		return null;
	}


}
