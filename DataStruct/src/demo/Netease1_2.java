package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Netease1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t1 = 0, t2 = 0;
		HashMap<Integer, Integer> hs = new HashMap<>();
		int[] a = new int[n + m];
		int[] b = new int[m];
		for (int i = 0; i < n; i++) {
			t1 = sc.nextInt();
			t2 = sc.nextInt();
			a[i] = t1;
			hs.put(t1, t2);
		}
		for (int i = 0; i < m; i++) {
			t1 = sc.nextInt();
			a[n + i] = t1;
			b[i] = t1;
			if (!hs.containsKey(t1))
				hs.put(t1, 0);
		}
		Arrays.sort(a);
		int max = 0;
		for (int i = 0; i < m + n; i++) {
			max = Math.max(max, hs.get(a[i]));
			hs.put(a[i], max);
		}
		for (int i = 0; i < m; i++) {
			System.out.println(hs.get(b[i]));
		}
	}

}
