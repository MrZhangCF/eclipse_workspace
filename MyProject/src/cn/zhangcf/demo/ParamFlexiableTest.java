package cn.zhangcf.demo;

public class ParamFlexiableTest {
	public static void main(String[] args) {
		System.out.println(add());
		System.out.println(add(1, 2, 3));
		System.out.println(add(new int [] {1,2,2}));
	}
	
	/**
	 * ʵ��������Ϊ�ɱ��������ӣ�����...�����Ϊ���飬�����������ĺ͡�
	 * @param data �ɱ��������Ϊ�գ����ֻ������飻
	 * @return ���ֵ
	 */
	public static int add(int ... data){
		int sum = 0;
		for(int i = 0 ; i < data.length; i++){
			sum += data[i];
		}
		return sum;
	}
}
