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
			System.out.println(Thread.currentThread().getName() + " ��Ʊ, ticket = " + this.ticket --);
		}
	}
	
}
public class MyThread6 {
	public static void main(String[] args) {
		Ticket tk = new Ticket();
		Thread t1 = new Thread(tk, "��ţA");
		Thread t2 = new Thread(tk, "��ţB");
		Thread t3 = new Thread(tk, "��ţC");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}
}
