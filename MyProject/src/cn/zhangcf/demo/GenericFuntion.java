package cn.zhangcf.demo;

public class GenericFuntion {
	public static void main(String[] args) {
		Integer result[] = fun(1, 2, 3, 4);
		for(int temp:result){
			System.out.println(temp);
		}
	}
	
	//这里<T>表示泛型说明
	public static <T> T[] fun(T ... args){
		return args;
	}
}
