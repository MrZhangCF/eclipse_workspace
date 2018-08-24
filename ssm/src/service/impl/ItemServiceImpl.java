package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.ItemsMapper;
import pojo.Items;
import pojo.ItemsExample;
import service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemsMapper im;
	
	@Override
	public List<Items> getItemList() {
		ItemsExample example = new ItemsExample();
		List<Items> list = im.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public Items getItemById(int id) {
		Items items = im.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItems(Items items) {
		im.updateByPrimaryKeySelective(items);
	}
	
}
