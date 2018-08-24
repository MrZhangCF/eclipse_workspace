package cn.zhangcf.demo;

//Reflection2�еĹ������ģʽ��˵�Ѿ��õ����������ǻ��Ǵ���ȱ�ݣ����˵����ʮ����ӿڣ�
//��ô����Ҫ��ʮ�������������ʮ�������ʵ�ֵĶ�����ͬ�Ĺ��ܣ����������˷ѡ�
//���Կ���ͨ�����������д���

interface IMessagee {
	public void eat();
}

class IMessageeImpl implements IMessagee {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("��IMessageeImpl����ӡ����");
	}

}

class Factoryy {
	private Factoryy() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className) throws Exception {
		
		return (T) Class.forName(className).newInstance();
		
	}
}

public class Reflection3 {
	public static void main(String[] args) throws Exception {
		IMessagee msg = Factoryy.getInstance("cn.zhangcf.demo.IMessageeImpl");
		msg.eat();
		IFruit msg2 = Factoryy.getInstance("cn.zhangcf.demo.Apple");
		msg2.eat();
		
		//�����ϵĴ����֪��ͨ������ͨ�Ĺ������ģʽ����ӷ���ͷ���֮�󣬿��Ժܺõ���Ӧ�������ƹ��ܵĹ������С�
	}
}
