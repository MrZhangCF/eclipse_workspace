package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest extends Thread {
	private int index;

	public ConcurrentTest(int i) {
		this.index = i;
	}

	@Override
	public void run() {

		try {
			//System.out.println("[" + this.index + "] start ...");
			Thread.sleep((int) (Math.random() * 10000));
			System.out.println(Thread.currentThread().getName()+"[" + this.index + "] end ...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(int i=0;i<10;i++){
			service.execute(new ConcurrentTest(i));
		}
		System.out.println("submit finish");
		service.shutdown();
	}
}
