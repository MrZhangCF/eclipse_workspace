package demo;

import java.util.Scanner;

public class JDTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String results[] = new String[num];
		for(int x=0;x<num;x++){
			String str = sc.next();
			results[x] = fun(str);
		}
		for(int x=0;x<num;x++){
			System.out.println(results[x]);
		}
		
	}
	public static String fun(String str){
		String [] strs = str.split("");
		int count = 0;
		for(int x=0;x<strs.length;x++){
			if(strs[x].equals("(")){
				count++;
			}else{
				count--;
				if(count <=-2){
					return "No";
				}
			}
		}
		if(count==0)
			return "Yes";
		else{
			return "No";
		}
	}
}
