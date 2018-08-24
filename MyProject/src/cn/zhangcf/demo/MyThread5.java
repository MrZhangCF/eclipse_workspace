package cn.zhangcf.demo;

class Tickets implements Runnable {
	private int ticket = 30;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 60; x++) {
			synchronized (this) {
				if (this.ticket > 0) {
					try {
						Thread.sleep(400);// 模拟网络延迟，会加重不同步现象。
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " 卖票, tickets = " + this.ticket--);
				}
			}
		}
	}

}

public class MyThread5 {
	public static void main(String[] args) {
		Tickets t1 = new Tickets();
		Thread th1 = new Thread(t1, "黄牛  A");
		Thread th2 = new Thread(t1, "黄牛  B");
		Thread th3 = new Thread(t1, "黄牛  C");
		th1.setPriority(Thread.MIN_PRIORITY);
		th1.start();
		th2.start();
		th3.start();
		

	}
}
