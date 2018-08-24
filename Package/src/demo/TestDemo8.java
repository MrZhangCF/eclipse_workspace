package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestDemo8 {

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();

		final String filename = "D:\\TEMCONH.OUT";

		final Integer COUNT = 463 * 36;

		File file = new File(filename);

		int[] cols = new int[COUNT];
		int[] rows = new int[COUNT];
		double[] salis = new double[COUNT];

		if (file.exists() && file.isFile()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			int allCount = 0;
			int itemCount = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				allCount++;
				if (allCount > 4) {
					String[] strs = lineTxt.split("\\s+");
					if (strs.length >= 4) {
						cols[itemCount] = Integer.parseInt(strs[1]);
						rows[itemCount] = Integer.parseInt(strs[2]);
						salis[itemCount] = Double.parseDouble(strs[3]);
						itemCount++;
					}

				}
			}
			bufferedReader.close();
			read.close();
		}

		long endTime = System.currentTimeMillis();

		int num = 1;

		System.out.print("[");
		for (int i = 0; i < 463 * num - 1; i++) {
			System.out.print(salis[i] + ",");
		}
		System.out.println(salis[463*num-1] + "]");
		System.out.println("¹²  " + salis.length + " Ìõ£¬ ºÄÊ± " + (endTime - startTime) + " ms");
	}
}
