package cn.zhangcf.demo;
interface IColor{
	public String getColor();
}
enum Colorsss implements IColor{
	RED("ºìÉ«"), GREEN("ÂÌÉ«"), BLUE("À¶É«");
	private String title;
	private Colorsss(String title){
		this.title = title;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.title;
	}
	
}
public class Enumerate3 {
	public static void main(String[] args) {
		System.out.println(Colorsss.RED.getColor());
	}
}
