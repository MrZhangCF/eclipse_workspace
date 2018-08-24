package cn.zhangcf.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//Callable有返回值，而Runnable没有
class MyThreads implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		for(int x = 0;x < 20;x++){
			System.out.println("卖票， x = " + x);
		}
		return "票卖完了， 明天再来吧！";
	}
	
}
public class MyThread4 {
	public static void main(String[] args) throws Exception {
		FutureTask<String> task = new FutureTask<>(new MyThreads());
		new Thread(task).start();
		System.out.println(task.get());
	}
}
