package cn.zhangcf.demo;

//这里使用T表示泛型，T可以为所有的数据结构，在对象创建的时候需要对T的类型进行指明，
//可以是常见的数据类型，也可以是自己创建的类。
class Point<T>{
	private T x;
	private T y;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	
}

public class Generic {
	public static void main(String[] args) {
		Point<String> pt = new Point<>();//注意这里的对象的生成方式。
		pt.setX("美国");
		pt.setY("中国");
		
		String x = pt.getX();
		String y = pt.getY();
		
		System.out.println(x);
		System.out.println(y);
		fun(pt);
	}
	//注意：这里使用了通配符，表示在程序编译的时候可以根据上文中所定义的泛型类型来进行
	//    选择在该方法中所使用的泛型类型。
	
	public static void fun(Point<?> temp){
		System.out.println(temp.getX());
	}
}
