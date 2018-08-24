package cn.zhangcf.demo;

enum Colorss{
	RED("红色"), GREEN("绿色"), BLUE("蓝色");//枚举对象必须放在第一行
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
