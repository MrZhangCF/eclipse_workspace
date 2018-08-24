package anwser;

import java.util.HashMap;
import java.util.Map;

public class No28 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int length = array.length;
		Map<Integer,Integer> map = new HashMap<>();
		
		for (int i : array) {
			if(!map.containsKey(i)){
				map.put(i, 1);
			}else{
				int value = map.get(i);
				map.put(i, ++value);
			}
		}
		
		//System.out.println(map.size());
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			//System.out.println(entry.getValue());
			if(entry.getValue() > length / 2){
				return entry.getKey();
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(new No28().MoreThanHalfNum_Solution(array));
	}
}
