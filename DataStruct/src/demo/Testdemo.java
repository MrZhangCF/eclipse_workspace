package demo;

import java.util.Scanner;

public class Testdemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String strs[] = str.split("");
		int length = str.length();
		int count = 0;

		int lim = 1 << length;

		for (int x = 0; x < lim; x++) {
			String temp = "";
			for (int y = 0; y < length; y++) {
				if ((x >> y) % 2 == 1) {
					temp += strs[y];
				}
			}
			if (check(temp)) {
				count++;
			}
		}
		System.out.println(count - 1);
	}

	public static boolean check(String str) {
		if (str.equals(null))
			return false;
		int length = str.length();
		String strs[] = str.split("");
		for (int x = 0; x < length / 2; x++) {
			if (strs[x].equals(strs[length - x - 1])) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}