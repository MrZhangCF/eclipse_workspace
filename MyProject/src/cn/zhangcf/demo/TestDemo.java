package cn.zhangcf.demo;

import java.util.Scanner;

public class TestDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		String label[] = { "Unspecified", "Loopback", "LinkLocal", "SiteLocal", "GlobalUnicast", "Multicast", "Error" };
		String inputs[] = input.split(":");
		int count = 0;
		for (int x = 0; x < inputs.length; x++) {
			if (inputs[x].equals("0000")) {
				count++;
			}
		}
		if (count == 32) {
			System.out.println(label[0]);
			return;
		}
		String strs[] = inputs[inputs.length - 1].split("");
		if (strs[strs.length - 1].equals("1")) {
			System.out.println(label[1]);
			return;
		}
		String strs2[] = inputs[0].split("");
		//StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		for(int y=0;y<strs2.length-1;y++){
			//newStr += strs2[y];
			sb1.append(strs2[y]);
		}
		String newStr = sb1.toString();
		//System.out.println(newStr);
		if(newStr.equals("FE8")){
			System.out.println(label[2]);
			return;
		}else if(newStr.equals("FEC")){
			System.out.println(label[3]);
			return;
		}
		
		StringBuffer sb2 = new StringBuffer();
		for(int s=0;s<2;s++){
			//newStr2 +=strs2[s];
			sb2.append(strs2[s]);
		}
		String newStr2 = sb2.toString();
		if(newStr2.equals("FF")){
			System.out.println(label[5]);
			return ;
		}
		System.out.println(label[6]);
	}
}