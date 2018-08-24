package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestDemo7 {

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();

		final String filename = "D:\\TEMCONH.OUT";

		File file = new File(filename);
		List<String> list = new ArrayList<String>();

		if (file.exists() && file.isFile()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file));
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			int count = 0;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				count++;
				if (count > 4) {
					if (lineTxt.split("\\s+").length >= 4) {
						list.add(lineTxt);
					}
				}
			}
			bufferedReader.close();
			read.close();
		}
		int[] cols = new int[list.size()];
		int[] rows = new int[list.size()];
		double[] salis = new double[list.size()];
		int[] colors = new int[463];

		for (int i = 0; i < list.size(); ++i) {
			String[] strs = list.get(i).split("\\s+");
			if (strs.length >= 4) {
				cols[i] = Integer.parseInt(strs[1]);
				rows[i] = Integer.parseInt(strs[2]);
				salis[i] = Double.parseDouble(strs[3]);
			}
		}
		long endTime = System.currentTimeMillis();
		for (int i = 0; i < salis.length; i++) {

			System.out.println(cols[i]);
			System.out.println(rows[i]);
			System.out.println(salis[i]);
			System.out.println();
		}
		// System.out.print("[");
		// for (int i = 0; i < 462; ++i) {
		// System.out.print(salis[i] + ", ");
		// }
		// System.out.println(salis[462] + "]");

		//System.out.println("¹²  " + salis.length + " Ìõ£¬ ºÄÊ± " + (endTime - startTime) + " ms");

		double min = getMin(salis);
		double length = getMax(salis) - min;
		int maxColor = 0xFF0000;
		int minColor = 0x00FF00;
		System.out.println("var colors = {");
		for (int num = 0; num < 15; num++) {
			int start = 463 * num;
			int end = start + 463;
			System.out.print("[");
			for (int i = start; i < end; ++i) {
				colors[i-start] = (int) ((maxColor - minColor) * (salis[i] - min) / length) + minColor;
				System.out.print("\"" + Integer.toHexString(colors[i-start]) + "\"" + ", ");
			}
			System.out.println("],");
		}
		//System.out.println("}");

	}

	public static int getMax(int[] arr) {

		int max = arr[0];

		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > max)
				max = arr[x];

		}
		return max;

	}

	public static double getMax(double[] arr) {

		double max = arr[0];

		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > max)
				max = arr[x];

		}
		return max;

	}

	public static int getMin(int[] arrInt) {

		int min = arrInt[0];
		for (int i = 0; i < arrInt.length; i++) {

			min = min > arrInt[i] ? arrInt[i] : min;

		}
		return min;
	}

	public static double getMin(double[] arrInt) {

		double min = arrInt[0];
		for (int i = 0; i < arrInt.length; i++) {

			min = min > arrInt[i] ? arrInt[i] : min;

		}
		return min;
	}
}
