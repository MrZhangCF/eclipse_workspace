package demo;
/*
 * 求两个非负整数的最大公约数:
 * 若q=0，则最大公约数为p；
 * 否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数
 */
public class Gcd {
	public static void main(String[] args) {
		System.out.println(gcd(3, 0));
		System.out.println(gcd(10, 4));
		System.out.println(gcd(4, 10));
		
	}
	
	public static int gcd(int p, int q){
		if(q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
}
