package cn.zhangcf.demo;

class ThreadDemo extends Thread{
	private String title ;
	public ThreadDemo(String title){
		this.title = title;
	}
	@Override
	public void run() {
		for(int x = 0;x < 10;x++){
			System.out.println(this.title + " + " + x);
		}
		
	}
	
}

public class MyThread {
	public static void main(String[] args) {
		ThreadDemo td1 = new ThreadDemo("线程A");
		ThreadDemo td2 = new ThreadDemo("线程B");
		td1.start();
		td2.start();
	}
}
