package cn.zhangcf.demo;

//lambda表达式是jdk1.8之后新更新的函数式编程方式，
//使用形式为：()->
//要求接口中只含有一个方法；
@FunctionalInterface
interface IMessager{
	public void print();
}

interface IMath{
	public int add(int x, int y);
}
public class Lambda {
	public static void main(String[] args) {
		IMessager msg = ()->System.out.println("HelloWorld");
		msg.print();
		
		IMath im = (p1, p2)->p1+p2;
		System.out.println(im.add(10, 20));
	}
	
	
}
