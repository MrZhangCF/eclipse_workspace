package cn.zhangcf.demo;

interface IMessage<T>{  //在接口上定义了泛型
	public void print(T t);
}

//第一种子类实现接口：子类也定义为泛型
class MessageImpl<T> implements IMessage<T>{

	@Override
	public void print(T t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}

//第二种子类实现接口：接口提供数据类型，子类则无需指明，但可以看到在覆写的
//方法中，类型已经更改为接口中定义的类型。
class Messager implements IMessage<String>{

	@Override
	public void print(String t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}
public class GenericInterface {
	public static void main(String[] args) {
		MessageImpl<Integer> impl = new MessageImpl<>();
		impl.print(10);
		Messager msger = new Messager();
		msger.print("HelloWorld");
	}
}
