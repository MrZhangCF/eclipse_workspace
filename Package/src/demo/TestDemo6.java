package demo;

import java.util.HashMap;
import java.util.Map;

public class TestDemo6 {
	
	public static void main(String[] args) {
		Map<HashMap<Integer,Integer>,Integer> map = new HashMap<>();
//		HashMap<Integer,Integer> keys = new HashMap<>();
//		Integer values = new Integer(0);
//		keys.put(10, 20);
		map.put(new HashMap<>(10,20), 30);
	}
}
