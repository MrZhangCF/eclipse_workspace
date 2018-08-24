package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestDemo9 {
	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();

		final String filename = "D:\\TEMCONH.OUT";

		//final Integer COUNT = 463*36;
		
		File file = new File(filename);

		Map<HashMap<Integer, Integer>,Double> map = new HashMap<>();
		
		if (file.exists() && file.isFile()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			int allCount = 0;
			HashMap<Integer,Integer> keys = new HashMap<>();
			while ((lineTxt = bufferedReader.readLine()) != null) {
				allCount++;
				if (allCount > 4) {
					String [] strs = lineTxt.split("\\s+");
					if (strs.length >= 4) {
						keys.put(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
						map.put(keys, Double.parseDouble(strs[3]));
					}
				}
			}
			bufferedReader.close();
			read.close();
		}
		
		long endTime = System.currentTimeMillis();
//		for (int i = 0; i < salis.length; i++) {
//			System.out.println(cols[i]);
//			System.out.println(rows[i]);
//			System.out.println(salis[i]);
//			System.out.println();
//		}
		System.out.println("¹²  " + map.size() + " Ìõ£¬ ºÄÊ± " + (endTime - startTime) + " ms");
	}
}
