package cn.zhangcf.demo;

//使用synchronized关键字定义get和set方法之后，可是解决线程的同步问题，
//但是重复问题依然存在。
class Providers implements Runnable{
	private Datas data;
	public Providers(Datas data){
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0;x < 50;x++){
			if(x % 2 == 0){
				this.data.set("title1", "note1");
			}else{
				this.data.set("title2", "note2");
			}
		}
	}
	
}

class Consumers implements Runnable{
	private Datas data;
	public Consumers(Datas data){
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0;x< 50;x++){
			this.data.get();
		}
	}
	
}

class Datas{
	private String title;
	private String note;
	public synchronized void get(){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.title + " = " + this.note);
	}
	public synchronized void set(String title, String note){
		this.title = title;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.note = note;
	}
	
}

public class ConsumerAndProvider2 {
	public static void main(String[] args) {
		Datas data = new Datas();
		new Thread(new Providers(data)).start();
		new Thread(new Consumers(data)).start();
	}
}
