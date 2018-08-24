package demo;

import java.util.Scanner;

/*
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。 
 *并且小Q对于能否被3整除这个性质很感兴趣。 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。 
 */

/**
 * 规律：直接对序号进行3的取模，可知道，余数为0和2的都可以被3整除。
 * @author zhangcf
 *
 */
public class Netease2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int result = 0;
		for(int i=l;i<=r;i++){
			switch(i%3){
			case 1:break;
			case 2:result++;break;
			case 0:result++;break;
			}
		}
		System.out.println(result);
	}
}
