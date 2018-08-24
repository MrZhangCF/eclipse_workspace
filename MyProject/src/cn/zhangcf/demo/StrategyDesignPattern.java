package cn.zhangcf.demo;

//�������ģʽ�����һ����������ж��ֲ���ʵ�֣������������⣨������ð�����򡢶����򡢿�������ȣ�
//		         �û�ͨ���������ģʽ�����ڻ��������ѡ����ԡ�

//����callback���������Դ������в��Զ���Ҫִ�еĲ���
interface ISameCallback {
	public void dotheSame();
}

// ������Խӿ�
interface IStrategy {
	public void execute(ISameCallback callback);
}

//����Ĳ���A
class StrategyA implements IStrategy {

	@Override
	public void execute(ISameCallback callback) {
		// TODO Auto-generated method stub
		callback.dotheSame();
		System.out.println("B->E->J->Z");
	}

}

//����Ĳ���B
class StrategyB implements IStrategy {

	@Override
	public void execute(ISameCallback callback) {
		// TODO Auto-generated method stub
		callback.dotheSame();
		System.out.println("B->C->D->F->I->Z");
	}

}

//����Ĳ���C
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
		
		//ִ��ʱֻ��Ҫ������Ӧ�Ĳ��Զ�������ת�ͳɸ��ӿڶ���Ȼ����ø��ӿ��еĹ�����������
		//�����Ҫִ�й����Ĳ���������Զ���callback�ӿڣ�ISameCallback��ʵ�ֹ���������
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
