package cn.zhangcf.demo;

interface IMessage<T>{  //�ڽӿ��϶����˷���
	public void print(T t);
}

//��һ������ʵ�ֽӿڣ�����Ҳ����Ϊ����
class MessageImpl<T> implements IMessage<T>{

	@Override
	public void print(T t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}

//�ڶ�������ʵ�ֽӿڣ��ӿ��ṩ�������ͣ�����������ָ���������Կ����ڸ�д��
//�����У������Ѿ�����Ϊ�ӿ��ж�������͡�
class Messager implements IMessage<String>{

	@Override
	public void print(String t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	
}
public class GenericInterface {
	public static void main(String[] args) {
		MessageImpl<Integer> impl = new MessageImpl<>();
		impl.print(10);
		Messager msger = new Messager();
		msger.print("HelloWorld");
	}
}
