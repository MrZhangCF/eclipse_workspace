package pojo;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
	public static void main(String[] args) {
		List<Integer> itemList = new ArrayList<>();
		itemList.add(10);
		itemList.add(20);
		itemList.add(30);
		itemList.add(40);
		itemList.add(50);
		System.out.println(itemList.get(0));
	}
}
