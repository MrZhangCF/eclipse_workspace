package cn.zhangcf.demo;

//ͨ���?��������������ࣺ
//1.���÷�������  ��extends ��
//    ��extends Number����ʾ�÷���ֻ�ܽ���Number�������࣬��Integer, Double��
//2.���÷�������  ��super ��
//    ��super String����ʾ�÷���ֻ�ܽ���String���丸�࣬Ҳ����Object��


//��ʾ��������
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
