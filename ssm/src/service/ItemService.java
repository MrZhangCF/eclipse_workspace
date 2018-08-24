package service;

import java.util.List;

import pojo.Items;

public interface ItemService {
	List<Items> getItemList();
	Items getItemById(int id);
	void updateItems(Items items);
}
