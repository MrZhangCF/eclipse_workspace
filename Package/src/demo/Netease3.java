package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Netease3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		int num = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < num; i++) {
			int pro_num = Integer.parseInt(sc.nextLine());
			Map<String,String> map = new HashMap<>();
			//String pros [] = new String[pro_num];
			for (int j = 0; j < pro_num; j++) {
				String line = sc.nextLine();
				String key = line.split(" ")[0].split("x")[0];
				String value = line.split(" ")[1];
				map.put(key, value);
			}
			int test_num = Integer.parseInt(sc.nextLine());
			
			for (int j = 0; j < test_num; j++) {
				String test = sc.nextLine();
				list.add(check(test, map));
			}
		}
		
		for (String string : list) {
			System.out.println(string);
		}
	}
	public static String check(String test, String[] pros){
		
		int length = pros.length;
		Map<String,String> map = new HashMap<>();
//		String new_pros[] = new String[length];
//		String add[] = new String[length];
		
		for (int i = 0; i < length; i++) {
//			new_pros[i] = pros[i].split(" ")[0].split("x")[0];
//			add[i] = pros[i].split(" ")[1];
//			
			String key = pros[i].split(" ")[0].split("x")[0];
			String value = pros[i].split(" ")[1];
			map.put(key, value);
		}
		
//		for (int i = 0; i < length; i++) {
//
//			if(test.substring(0, new_pros[i].length()).equals(new_pros[i])){
//				return add[i];
//			}
//		}
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			if(test.substring(0,entry.getKey().length()).equals(entry.getKey()))
				return entry.getValue();
		}
		return "unknown";
		
	}
public static String check(String test, Map<String, String> map){
		
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			if(test.substring(0,entry.getKey().length()).equals(entry.getKey()))
				return entry.getValue();
		}
		return "unknown";
		
	}
}
