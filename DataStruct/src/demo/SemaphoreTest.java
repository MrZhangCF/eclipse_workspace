package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * �������벻�ã�������
 * @author zhangcf
 *
 */

public class SemaphoreTest extends Thread {
	Semaphore position;
	private int id;

	public SemaphoreTest(int id, Semaphore s) {
		this.id = id;
		this.position = s;
	}

	@Override
	public void run() {

		try {
			if (position.availablePermits() > 0) {
				System.out.println("�˿�[" + this.id + "]����������п�λ");
			} else {
				System.out.println("�˿�[" + this.id + "]���������û��λ���Ŷ�");
			}
			position.acquire();
			System.out.println("�˿�[" + this.id + "]��ÿ�λ");
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("�˿�[" + this.id + "]ʹ�����");
			position.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService list = Executors.newCachedThreadPool();
		Semaphore position = new Semaphore(2);
		for (int i = 0; i < 10; i++) {
			list.submit(new SemaphoreTest(i, position));
		}
		list.shutdown();
		position.acquireUninterruptibly(2);
		System.out.println("ʹ�����,��Ҫ��ɨ��");
		position.release(2);
	}
}
