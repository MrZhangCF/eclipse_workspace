package demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] fav = new int[n];
		for(int i = 0;i<n;++i){
			fav[i] = sc.nextInt();
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int j = 0;j<n;++j){
			int key = fav[j];
			int value = j+1;
			if(!map.containsKey(key)){
				List<Integer> list = new LinkedList<>();
				list.add(value);
				map.put(key, list);
			}else{
				List<Integer> list = map.get(key);
				list.add(value);
			}
		}
		int q = sc.nextInt();
		for(int i = 0;i<q;++i){
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			
			int count = 0;
			if(map.containsKey(k)){
				List<Integer> list = map.get(k);
				for(Integer item:list){
					if(item>=l&&item<=r){
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
