package cn.zhangcf.demo;

//ö�٣�
//�ɶԱȶ������ģʽ����֪��ö��ʵ���Ͼ��Ǹ߼��Ķ������ģʽ��
//enum ��ö�ٵĹؼ��֣�enum��ʾ���༴��ʾΪ����̳���Enum��
//Enum�����ĸ��������ֱ��ǣ����췽����ȡ��ö�����ֵķ�����ȡ��ö����ŵķ�������ȡ��ö��ȫ��ʵ���ķ�����
enum Colors{
	RED, BLUE, GREEN;
}

public class enumerate {
	public static void main(String[] args) {
		for(Colors temp:Colors.values()){
			System.out.println(temp.ordinal() + " = " + temp.name());
		}
	}
}
