package cn.zhangcf.demo;

//lambda���ʽ��jdk1.8֮���¸��µĺ���ʽ��̷�ʽ��
//ʹ����ʽΪ��()->
//Ҫ��ӿ���ֻ����һ��������
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
