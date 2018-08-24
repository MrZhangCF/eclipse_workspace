package cn.zhangcf.demo;
class Ticket implements Runnable{
	private int ticket = 30;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x < 60;x ++){
			sale();
		}
	}
	public synchronized void sale(){
		if(this.ticket > 0){
			System.out.println(Thread.currentThread().getName() + " ÂôÆ±, ticket = " + this.ticket --);
		}
	}
	
}
public class MyThread6 {
	public static void main(String[] args) {
		Ticket tk = new Ticket();
		Thread t1 = new Thread(tk, "»ÆÅ£A");
		Thread t2 = new Thread(tk, "»ÆÅ£B");
		Thread t3 = new Thread(tk, "»ÆÅ£C");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
