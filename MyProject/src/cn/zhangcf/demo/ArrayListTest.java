package cn.zhangcf.demo;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(0, 5);
		//System.out.println(list.get(0));
		for(Integer num:list){
			System.out.print(num+" ");
		}
		System.out.println("");
		
		list.remove(3);
		for(Integer num:list){
			System.out.print(num+" ");
		}
		System.out.println("");
	}
}
