package demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {
	public static void main(String[] args) {
//		String reg = "(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0))+\\d";
//		String str = "123465478912312311112220";
//		Matcher m = Pattern.compile(reg).matcher(str);
//		while(m.find()){
//			if(m.group().length()>=3){
//				str = str.replace(m.group().substring(0,3), "");
//			}
//		}
//		String r2 = "([1]{3}|[2]{3}|[3]{2}|[4]{3}|[5]{3}|[6]{3}|[7]{3}|[8]{3}|[9]{3}|[0]{3})";
//		System.out.println(str.replaceAll(r2, ""));
		
		String reg2 = "((?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0)){2}\\d)";
		String str2 = "132365";
		Matcher m2 = Pattern.compile(reg2).matcher(str2);
		while(m2.find()){
			System.out.println("yes");
		}
		

	}
}