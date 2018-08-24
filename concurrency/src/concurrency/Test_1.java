package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_1 extends Thread{
	private int index;
	public Test_1(int i){
		this.index = i;
	}
	
	@Override
	public void run() {
		
		try {
			System.out.println("["+ this.index + "] starting...");
			Thread.sleep((int)(Math.random() * 10000));
			System.out.println("[" + this.index + "] end.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			service.execute(new Test_1(i));
		}
		
		System.out.println("submit finish");
		service.shutdown();
	}
}
