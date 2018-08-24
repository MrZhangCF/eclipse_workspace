package demo;

import java.util.Scanner;

public class Netease3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int longth[] = new int[num];
		String cons[] = new String[num];
		
		for (int x = 0; x < num; x++) {
			longth[x] = sc.nextInt();
			cons[x] = sc.next();
		}
		for (int x = 0; x < num; x++) {
			int count = 0;
			String strs[] = cons[x].split("X");
			for (int y = 0; y < strs.length; y++) {
				if (strs[y].length() % 3 == 0) {
					count += strs[y].length() / 3;
				} else {
					count += strs[y].length() / 3 + 1;
				}
			}
			System.out.println(count);
		}
	}
}
