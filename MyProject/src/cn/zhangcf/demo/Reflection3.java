package cn.zhangcf.demo;

//Reflection2中的工厂设计模式虽说已经得到改良，但是还是存在缺陷：如果说存在十万个接口，
//那么就需要有十万个工厂，而这十万个工厂实现的都是相同的功能，这就造成了浪费。
//所以可以通过泛型来进行处理。

interface IMessagee {
	public void eat();
}

class IMessageeImpl implements IMessagee {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("【IMessageeImpl】打印简历");
	}

}

class Factoryy {
	private Factoryy() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className) throws Exception {
		
		return (T) Class.forName(className).newInstance();
		
	}
}

public class Reflection3 {
	public static void main(String[] args) throws Exception {
		IMessagee msg = Factoryy.getInstance("cn.zhangcf.demo.IMessageeImpl");
		msg.eat();
		IFruit msg2 = Factoryy.getInstance("cn.zhangcf.demo.Apple");
		msg2.eat();
		
		//由以上的代码可知，通过在普通的工厂设计模式中添加反射和泛型之后，可以很好的适应各种相似功能的工厂类中。
	}
}
