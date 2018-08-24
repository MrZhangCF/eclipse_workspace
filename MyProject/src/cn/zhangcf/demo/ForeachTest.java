package cn.zhangcf.demo;

public class ForeachTest {
	//foreach即为增强型的for循环，可以避免数组的越界，适用于简单的数组遍历
	public static void main(String[] args) {
		int data [] = new int [] {1,2,34,5,6};
		for(int x:data){
			System.out.println(x);
		}
	}
	
}
