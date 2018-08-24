package cn.zhangcf.demo;
//模板方法设计模式：将不变的逻辑放在父类中，子类只需实现可变的部分。

//场景：去银行办业务：先取号，排队，办理业务（因业务多样，所以在子类实现），给客服人员评分，完毕。

//定义抽象类
abstract class ABankTemplateMethod {
	// 1.取号
	public void takeNumber() {
		System.out.println("取号");
	}

	// 2.排队
	public void joinLine() {
		System.out.println("排队");
	}

	// 3.办理业务
	public abstract void transact();

	// 4.评分
	public void evaluate() {
		System.out.println("评分");
	}

	// 模板调用方法
	public final void process() {
		this.takeNumber();
		this.joinLine();
		this.transact();
		this.evaluate();
	}
}

class DrawMoney extends ABankTemplateMethod {

	@Override
	public void transact() {
		System.out.println("存钱");
	}

}

public class TemplateMethodDesignPattern {
	public static void main(String[] args) {
		ABankTemplateMethod btm1 = new DrawMoney();
		btm1.process();
		ABankTemplateMethod btm2 = new ABankTemplateMethod(){

			@Override
			public void transact() {
				System.out.println("我要取钱");
			}
		};
	}
}
