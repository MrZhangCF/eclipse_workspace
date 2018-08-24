package cn.zhangcf.demo;

public class ParamFlexiableTest {
	public static void main(String[] args) {
		System.out.println(add());
		System.out.println(add(1, 2, 3));
		System.out.println(add(new int [] {1,2,2}));
	}
	
	/**
	 * 实现了输入为可变参数的相加，其中...可理解为数组，结果输出参数的和。
	 * @param data 可变参数，可为空，数字或者数组；
	 * @return 相加值
	 */
	public static int add(int ... data){
		int sum = 0;
		for(int i = 0 ; i < data.length; i++){
			sum += data[i];
		}
		return sum;
	}
}
