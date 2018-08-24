package demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Netease2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		//int num = sc.nextInt();
		String[] results = new String[num];
		for (int i = 0; i < results.length; i++) {
			String line = sc.nextLine();
			results[i] = check(line);
		}
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}

	public static String check(String pw) {

		if (pw.length() < 8) {
			return "no";
		}

		if (pw.contains("password") || pw.contains("admin") || pw.contains("qwerty") || pw.contains("hello")
				|| pw.contains("iloveyou") || pw.contains("112233")) {
			return "no";
		}

		String reg2 = "((?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0)){2}\\d)";

		Matcher m2 = Pattern.compile(reg2).matcher(pw);
		while (m2.find()) {
			return "no";
		}

		String reg3 = "(\\d)\1{2}";

		Matcher m3 = Pattern.compile(reg3).matcher(pw);
		while (m3.find()) {
			return "no";
		}
		
		return "yes";
	}
}
