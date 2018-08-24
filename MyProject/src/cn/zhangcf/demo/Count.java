package cn.zhangcf.demo;

public class Count {
	
	public static double jieCheng(int num){
		double count = 1;
		if(num == 0){
			return 1;
		}
		for(int x= num; x >0;x--){
			count = count * (double)x;
		}
		return count;
	}
	public static void main(String[] args) {
		double sum = 0;
		for(int x = 1;x < 21;x++){
			sum += jieCheng(x);
		}
		System.out.println(sum);
	}
}
