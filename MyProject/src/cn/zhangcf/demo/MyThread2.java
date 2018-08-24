package cn.zhangcf.demo;

class ThreadDemo2 implements Runnable{
	private String title;
	public ThreadDemo2(String title){
		this.title = title;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0;x<10;x++){
			System.out.println(this.title + " + " + x);
		}
		
	}
	
}

public class MyThread2 {
	public static void main(String[] args) {
		ThreadDemo2 td1 = new ThreadDemo2("线程A");
		ThreadDemo2 td2 = new ThreadDemo2("线程B");
		
		new Thread(td1).start();
		new Thread(td2).start();
	}
}
