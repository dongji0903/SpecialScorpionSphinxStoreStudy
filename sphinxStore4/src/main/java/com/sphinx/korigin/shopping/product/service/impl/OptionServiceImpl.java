package com.sphinx.korigin.shopping.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphinx.korigin.shopping.product.dao.impl.OptionDaoImpl;
import com.sphinx.korigin.shopping.product.dao.impl.OptionValueDaoImpl;
import com.sphinx.korigin.shopping.product.dao.impl.OptionsLinkDaoImpl;
import com.sphinx.korigin.shopping.product.domain.Option;
import com.sphinx.korigin.shopping.product.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {

	@Autowired
	private OptionDaoImpl optionDaoImpl;
	@Autowired
	private OptionValueDaoImpl optionValueDaoImpl;
	@Autowired
	private OptionsLinkDaoImpl optionsLinkDaoImpl;

	@Override
	public void addOption(Map<String, Option> optionMap,
			Map<String, String> keyMap, Map<String, String> valueMap,
			String productId) {
		for (String optionKey : optionMap.keySet()) {
			Option option = optionMap.get(optionKey);
			String optionId = optionDaoImpl.insertOption(option.getOptionName(),
					productId);
			option.setOptionId(optionId);
			Map<String, Double> optionValue = new HashMap<>();
			for (String key : keyMap.keySet()) {
				String[] array1 = key.split("_");
				if (optionKey.equals(array1[1])) {
					for (String valueKey : valueMap.keySet()) {
						String[] array2 = valueKey.split("_");
						if (array2[1].equals(array1[1])
								&& array2[2].equals(array1[2])) {
							optionValue.put(keyMap.get(key),
									Double.valueOf(valueMap.get(valueKey)));
							System.out.println("optionValue key: "
									+ keyMap.get(key) + ", value: "
									+ valueMap.get(valueKey));
							option.setOptionValue(optionValue);
							System.out.println(option);
							String optionValueId = optionValueDaoImpl
									.insertOptionValue(option);
							optionsLinkDaoImpl.insertLink(optionId,
									optionValueId);
						}
					}
				}
			}
		}
	}

	@Override
	public void updateOption(Option option) {
		optionDaoImpl.updateOption(option);
	}

	@Override
	public void deleteOption(Option option) {

	}

	@Override
	public Option getOptionById(String optionId) {
		return optionDaoImpl.selectOptionById(optionId);
	}

	@Override
	public List<Option> getOptionListByProductId(String productId) {
		return optionDaoImpl.selectOptionListByProductId(productId);
	}
}
