package cn.zhangcf.demo;
class Datass{
	private String title;
	private String note;
	//flag = true:表示允许生产，但是不允许消费者取走
	//flag = false:表示生产完毕，允许消费者取走，但是不能够生产
	private boolean flag = false;
	public synchronized void get(){
		if(flag == false){
			try {
				super.wait(); // 线程等待；
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.title + " + " + this.note);
		
		this.flag = false;  // 表示消费完成，允许生产。
		super.notify(); // 唤醒等待的线程。
	}
	
	public synchronized void set(String title, String note){
		if(this.flag == true){
			try {
				super.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.note = note;
		
		this.flag = true; // 表示生产过了，不允许再生产。
		super.notify();  // 唤醒等待的线程
	}
}

class Providerss implements Runnable{
	private Datass data;
	public Providerss(Datass data){
		this.data = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x < 50; x ++){
			if(x % 2 == 0){
				this.data.set("title1", "note1");
			}else{
				this.data.set("title2", "note2");
			}
		}
	}
}

class Consumerss implements Runnable{
	private Datass data;
	public Consumerss(Datass data){
		this.data = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x < 50; x++){
			this.data.get();
		}
	}
}
public class ConsumerAndProvider3 {
	public static void main(String[] args) {
		Datass data = new Datass();
		new Thread(new Providerss(data)).start();
		new Thread(new Consumerss(data)).start();
	}
}
