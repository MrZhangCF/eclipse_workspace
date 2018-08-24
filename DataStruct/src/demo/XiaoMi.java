package demo;

import java.util.Scanner;

public class XiaoMi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fun(num));
	}

	public static int fun(int n) {
		int[] result = new int[n];

		if(n==1 || n==2){
			return n;
		}
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];
	}
}
