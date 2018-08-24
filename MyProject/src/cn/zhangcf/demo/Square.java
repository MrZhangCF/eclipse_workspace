package cn.zhangcf.demo;

import java.util.Scanner;

public class Square {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int x[] = new int[4];
		int y[] = new int[4];
		
		String flag = "No";
		for(int i = 0;i < t;i++){
			for(int k = 0;k<2;k++){
				for(int s=0;s< 4;s++){
					if(k==0){
						x[s]=in.nextInt();
					}else{
						y[s]=in.nextInt();
					}
				}
			}
			boolean flag1 = check(new int[]{x[0],y[0],x[1],y[1],x[2],y[2],x[3],y[3]});
			boolean flag2 = check(new int[]{x[0],y[0],x[2],y[2],x[1],y[1],x[3],y[3]});
			boolean flag3 = check(new int[]{x[0],y[0],x[3],y[3],x[1],y[1],x[2],y[2]});
			if(flag1 == true && flag2 == true && flag3 == true){
				flag = "Yes";
			}
			System.out.println(flag);
		}
		
	}
	
	public static boolean check(int...is){
		double length = (is[0] - is[2])*(is[0] - is[2]) + (is[1]-is[3])*(is[1] - is[3]);
		double length2 = (is[4] - is[6])*(is[4] - is[6]) + (is[5]-is[7])*(is[7] - is[7]);
		return length == length2;
	}
}
