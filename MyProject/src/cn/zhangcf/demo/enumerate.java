package cn.zhangcf.demo;

//枚举：
//可对比多例设计模式，可知，枚举实质上就是高级的多例设计模式。
//enum 是枚举的关键字，enum标示的类即表示为该类继承了Enum类
//Enum类有四个方法：分别是：构造方法，取得枚举名字的方法，取得枚举序号的方法，和取得枚举全部实例的方法。
enum Colors{
	RED, BLUE, GREEN;
}

public class enumerate {
	public static void main(String[] args) {
		for(Colors temp:Colors.values()){
			System.out.println(temp.ordinal() + " = " + temp.name());
		}
	}
}
