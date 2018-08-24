package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Test_2 extends Thread{
	private Semaphore position;
	private int id;
 
	public Test_2(int i, Semaphore s) {
		this.id = i;
		this.position = s;
	}
 
	public void run() {
		try {
			//��û�пղ���
//			if (position.availablePermits() > 0) {
//				System.out.println("�˿�[" + this.id + "]����������п�λ");
//			}else {
//				System.out.println("�˿�[" + this.id + "]���������û��λ���Ŷ�");
//			}
			//��ȡ���ղ�����
			position.acquire();
			System.out.println("�˿�[" + this.id + "]��ÿ�λ");
			//ʹ����...
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("�˿�[" + this.id + "]ʹ�����");
			//����ʹ����֮���ͷ�
			position.release();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static void main(String args[]) {
		ExecutorService list = Executors.newCachedThreadPool();
		Semaphore position = new Semaphore(2);//ֻ����������
		//��ʮ����
		for (int i = 0; i < 10; i++) {
			list.submit(new Test_2(i + 1, position));
		}
		list.shutdown();
		position.acquireUninterruptibly(2);
		System.out.println("ʹ����ϣ���Ҫ��ɨ��");
		position.release(2);
		
		
	}

}
