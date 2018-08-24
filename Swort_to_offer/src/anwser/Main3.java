package anwser;

import java.util.HashMap;
import java.util.Map;

public class Main3 {

	public static void main(String args[]) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(1, 2);
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		System.out.println(map.containsKey(1));
	}
}
