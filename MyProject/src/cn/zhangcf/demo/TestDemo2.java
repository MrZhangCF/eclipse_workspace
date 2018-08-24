package cn.zhangcf.demo;

import java.util.Scanner;

public class TestDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		int total = Integer.parseInt(line1);
		String line2 = sc.nextLine();
		String line3 = sc.nextLine();
		String str1[] = line2.split(" ");
		String str2[] = line3.split(" ");
		int [] first = new int[str1.length];
		int [] second = new int[str1.length];
		
		for(int x=0;x<str1.length;x++){
			//
			first[x] = Integer.parseInt(str1[x]);
			System.out.println(first[x]);
		}
		//System.out.println(line1);
		//System.out.println(line2);
		//System.out.println(line3);
		
		
	}
}
