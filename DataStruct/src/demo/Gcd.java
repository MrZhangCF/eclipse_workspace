package demo;
/*
 * �������Ǹ����������Լ��:
 * ��q=0�������Լ��Ϊp��
 * ���򣬽�p����q�õ�����r��p��q�����Լ����Ϊq��r�����Լ��
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
