package cn.zhangcf.demo;

//�������ģʽ��
//��������Ŀ���������Ʊ���ʵ��������Ĳ�������,��Ϊ�ڹ��캯���ϴ���private���ƣ�����ֻ��Ϊ
//������ʾ������ѡ�
class Color{
	private static final Color RED = new Color("RED");
	private static final Color GREEN = new Color("GREEN");
	private static final Color BLUE = new Color("BLUE");
	private String title;
	private Color(String title){
		this.title = title;
	}
	public static Color getInstance(int ch){
		switch(ch){
		case 0:return RED;
		case 1:return GREEN;
		case 2:return BLUE;
		default:return null;
		}
		
	}
	public String toString(){
		return this.title;
	}
}
public class MutiDesignPattern {
	public static void main(String[] args) {

		System.out.println(Color.getInstance(0));
		System.out.println(Color.getInstance(1));
		System.out.println(Color.getInstance(2));
		System.out.println(Color.getInstance(2));
	}
}
