package demo;

import java.util.Scanner;

/*
 * СQ�õ�һ�����������: 1, 12, 123,...12345678910,1234567891011...�� 
 *����СQ�����ܷ�3����������ʺܸ���Ȥ�� СQ����ϣ�����ܰ�������һ�´����еĵ�l������r��(�����˵�)�ж��ٸ������Ա�3������ 
 */

/**
 * ���ɣ�ֱ�Ӷ���Ž���3��ȡģ����֪��������Ϊ0��2�Ķ����Ա�3������
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
