package cn.zhangcf.demo;
//�������ģʽ
interface IFruit{
	public void eat();
}
class Apple implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("��Apple����ƻ��");
	}
}

class Orange implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("��Orange��������");
	}
}

class Pear implements IFruit{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("��Pear������");
	}
}

class Factory{

	private Factory() {}
	public static IFruit getInstance(String className) throws Exception{
//		if("apple".equals(className)){
//			return new Apple(); //�˴�ʹ��new Apple()�����ж���Ĵ�����������ʵ�ʵ�Ӧ���У����ǲ�����ÿһ���඼ʹ��һ��if������������жϡ� ��
//								//���Դ�ͳ�Ĺ������ģʽ�����׶˾���new��������������õķ�ʽ����ʹ�÷�������ɡ�
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
