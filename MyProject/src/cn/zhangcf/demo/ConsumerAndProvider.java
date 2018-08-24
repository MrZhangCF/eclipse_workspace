package cn.zhangcf.demo;

class Provider implements Runnable{
	private Data data;
	public Provider(Data data){
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0;x<50;x++){
			if(x % 2 == 0){
				this.data.setTitle("title1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.data.setNote("note1");
			}else{
				this.data.setTitle("title2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.data.setNote("note2");
			}
		}
	}
	
}

class Consumer implements Runnable{
	private Data data;
	public Consumer(Data data){
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0;x< 50;x++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.data.getTitle() + " = " + this.data.getNote());
		}
	}
	
}

class Data{
	private String title;
	private String note;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
public class ConsumerAndProvider {
	public static void main(String[] args) {
		Data data = new Data();
		new Thread(new Provider(data)).start();
		new Thread(new Consumer(data)).start();
	}
}
