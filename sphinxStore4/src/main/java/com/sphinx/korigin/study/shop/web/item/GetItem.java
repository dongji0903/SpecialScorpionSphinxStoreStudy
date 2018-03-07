package com.sphinx.korigin.study.shop.web.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dug.controller.command.Command;
import com.dug.dao.shop.ItemDao;
import com.dug.dao.shop.impl.ItemDaoImpl;
import com.dug.domain.shop.Item;
import com.dug.vto.shop.ItemVto;

public class GetItem extends Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		String num = request.getParameter("num");
		if (request.getAttribute("num") != null) {
			num = (String) request.getAttribute("num");
		}

		ItemDao iDao = ItemDaoImpl.getInstance();
		
		Item item = iDao.selectItem(num);
		List<Item> itemList = iDao.selectItems(item.getName());
		List<ItemVto> options = new ArrayList<>();
		List<String> sub_Opt = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		
		String opt = itemList.get(0).getType1();
		
		for(int i = 0; i < itemList.size(); i++) {
			sub_Opt.add(itemList.get(i).getType2());
			ids.add(itemList.get(i).getNum());
			
			//옵션 셋팅하기(옵션값이 다르면 리스트에 추가)
			if(!opt.equals(itemList.get(i).getType1()) || i+1 == itemList.size()){				
				ItemVto oVto = new ItemVto();
				oVto.setOption(opt);
				oVto.setSub_Option(sub_Opt);
				oVto.setOption_Ids(ids);
				options.add(oVto);
				
				sub_Opt = null;
				ids = null;		
				opt = itemList.get(i).getType1();
			}
		}
		
		request.setAttribute("item", item);
		request.setAttribute("options", options);

		return getNextPage();

	}

}
