package cn.zhangcf.demo;

//����ʹ��T��ʾ���ͣ�T����Ϊ���е����ݽṹ���ڶ��󴴽���ʱ����Ҫ��T�����ͽ���ָ����
//�����ǳ������������ͣ�Ҳ�������Լ��������ࡣ
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
		Point<String> pt = new Point<>();//ע������Ķ�������ɷ�ʽ��
		pt.setX("����");
		pt.setY("�й�");
		
		String x = pt.getX();
		String y = pt.getY();
		
		System.out.println(x);
		System.out.println(y);
		fun(pt);
	}
	//ע�⣺����ʹ����ͨ�������ʾ�ڳ�������ʱ����Ը���������������ķ�������������
	//    ѡ���ڸ÷�������ʹ�õķ������͡�
	
	public static void fun(Point<?> temp){
		System.out.println(temp.getX());
	}
}
