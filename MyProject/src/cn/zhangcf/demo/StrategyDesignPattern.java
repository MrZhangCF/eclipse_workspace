package cn.zhangcf.demo;

//策略设计模式：解决一个问题可以有多种策略实现，比如排序问题（可以有冒泡排序、堆排序、快速排序等）
//		         用户通过策略设计模式可以在机动的灵活选择策略。

//定义callback函数，用以处理所有策略都需要执行的步骤
interface ISameCallback {
	public void dotheSame();
}

// 定义策略接口
interface IStrategy {
	public void execute(ISameCallback callback);
}

//具体的策略A
class StrategyA implements IStrategy {

	@Override
	public void execute(ISameCallback callback) {
		// TODO Auto-generated method stub
		callback.dotheSame();
		System.out.println("B->E->J->Z");
	}

}

//具体的策略B
class StrategyB implements IStrategy {

	@Override
	public void execute(ISameCallback callback) {
		// TODO Auto-generated method stub
		callback.dotheSame();
		System.out.println("B->C->D->F->I->Z");
	}

}

//具体的策略C
class StrategyC implements IStrategy {

	@Override
	public void execute(ISameCallback callback) {
		// TODO Auto-generated method stub
		callback.dotheSame();
		System.out.println("B->C->D->H->I->Z");
	}
}

public class StrategyDesignPattern {
	public static void main(String[] args) {
		
		//执行时只需要创建对应的策略对象，向上转型成父接口对象，然后调用父接口中的公共方法即可
		//如果需要执行公共的操作，则可以定义callback接口（ISameCallback）实现公共操作。
		IStrategy isa = new StrategyA();
		isa.execute(new ISameCallback() {

			@Override
			public void dotheSame() {
				// TODO Auto-generated method stub
				System.out.print("A->");
			}
		});
		IStrategy isb = new StrategyB();
		isb.execute(new ISameCallback() {

			@Override
			public void dotheSame() {
				// TODO Auto-generated method stub
				System.out.print("A->");
			}
		});
	}
}
