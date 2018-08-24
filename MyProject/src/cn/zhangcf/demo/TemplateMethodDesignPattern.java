package cn.zhangcf.demo;
//ģ�巽�����ģʽ����������߼����ڸ����У�����ֻ��ʵ�ֿɱ�Ĳ��֡�

//������ȥ���а�ҵ����ȡ�ţ��Ŷӣ�����ҵ����ҵ�����������������ʵ�֣������ͷ���Ա���֣���ϡ�

//���������
abstract class ABankTemplateMethod {
	// 1.ȡ��
	public void takeNumber() {
		System.out.println("ȡ��");
	}

	// 2.�Ŷ�
	public void joinLine() {
		System.out.println("�Ŷ�");
	}

	// 3.����ҵ��
	public abstract void transact();

	// 4.����
	public void evaluate() {
		System.out.println("����");
	}

	// ģ����÷���
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
		System.out.println("��Ǯ");
	}

}

public class TemplateMethodDesignPattern {
	public static void main(String[] args) {
		ABankTemplateMethod btm1 = new DrawMoney();
		btm1.process();
		ABankTemplateMethod btm2 = new ABankTemplateMethod(){

			@Override
			public void transact() {
				System.out.println("��ҪȡǮ");
			}
		};
	}
}
