package cn.zhangcf.demo;

public class MyThread3 {
	public static void main(String[] args) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("HelloWorld");
			}
			
		}).start();
	}
}
