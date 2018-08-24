package cn.zhangcf.demo;

//多例设计模式：
//这样做的目的在于限制本类实例化对象的产生个数,因为在构造函数上存在private限制，所以只能为
//如下所示的三种选项。
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
