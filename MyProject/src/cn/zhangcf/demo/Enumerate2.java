package cn.zhangcf.demo;

enum Colorss{
	RED("��ɫ"), GREEN("��ɫ"), BLUE("��ɫ");//ö�ٶ��������ڵ�һ��
	private String title ;
	private Colorss(String title){
		this.title = title;
	}
	public String toString(){
		return this.title;
	}
}

public class Enumerate2 {
	public static void main(String[] args) {
		for(Colorss temp:Colorss.values()){
			System.out.println(temp);
		}
	}
}
