package cn.zhangcf.demo;
//工厂设计模式
interface IFruit{
	public void eat();
}
class Apple implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("【Apple】吃苹果");
	}
}

class Orange implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("【Orange】吃橘子");
	}
}

class Pear implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("【Pear】吃梨");
	}
}

class Factory{

	private Factory() {}
	public static IFruit getInstance(String className) throws Exception{
//		if("apple".equals(className)){
//			return new Apple(); //此处使用new Apple()来进行对象的创建，但是在实际的应用中，我们不可能每一个类都使用一个if代码块来进行判断。 、
//								//所以传统的工厂设计模式的最大弊端就是new创建对象，所以最好的方式就是使用反射来完成。
//		}
		return (IFruit) Class.forName(className).newInstance();
	}
}
public class Reflection2 {
	public static void main(String[] args) throws Exception {
		Factory.getInstance("cn.zhangcf.demo.Apple").eat();
		Factory.getInstance("cn.zhangcf.demo.Orange").eat();
		Factory.getInstance("cn.zhangcf.demo.Pear").eat();
		
	}
}
