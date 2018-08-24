package cn.zhangcf.demo;
class Datass{
	private String title;
	private String note;
	//flag = true:��ʾ�������������ǲ�����������ȡ��
	//flag = false:��ʾ������ϣ�����������ȡ�ߣ����ǲ��ܹ�����
	private boolean flag = false;
	public synchronized void get(){
		if(flag == false){
			try {
				super.wait(); // �̵߳ȴ���
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
		
		this.flag = false;  // ��ʾ������ɣ�����������
		super.notify(); // ���ѵȴ����̡߳�
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
		
		this.flag = true; // ��ʾ�������ˣ���������������
		super.notify();  // ���ѵȴ����߳�
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
