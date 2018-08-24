package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 样例代码不好！差评！
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
				System.out.println("顾客[" + this.id + "]进入厕所，有空位");
			} else {
				System.out.println("顾客[" + this.id + "]进入厕所，没空位，排队");
			}
			position.acquire();
			System.out.println("顾客[" + this.id + "]获得坑位");
			Thread.sleep((int) (Math.random() * 1000));
			System.out.println("顾客[" + this.id + "]使用完毕");
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
		System.out.println("使用完毕,需要打扫了");
		position.release(2);
	}
}
