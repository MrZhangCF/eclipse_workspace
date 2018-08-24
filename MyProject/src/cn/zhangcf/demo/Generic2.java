package cn.zhangcf.demo;

//通配符?延伸出的两个子类：
//1.设置泛型上限  ？extends 类
//    ？extends Number：表示该泛型只能接收Number或其子类，如Integer, Double等
//2.设置泛型上限  ？super 类
//    ？super String：表示该泛型只能接收String或其父类，也即是Object。


//表示泛型上限
class Message<T extends Number>{
	private T x;

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}
	
}

class Pointer<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

public class Generic2 {
	public static void main(String[] args) {
		Message<Integer> msg = new Message<>();
		msg.setX(20);
		fun1(msg);
		
		Pointer<String> pt = new Pointer<>();
		pt.setT("HelloWorld");
		fun2(pt);
	}
	public static void fun1(Message<? extends Number> temp){
		System.out.println(temp.getX());
	}
	public static void fun2(Pointer<? super String> temp){
		System.out.println(temp.getT());
	}
}
