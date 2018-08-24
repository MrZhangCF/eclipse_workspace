package demo;

class Consumer {
	private int procuct = 0;

	public synchronized void consume() {
		if (this.procuct <= 0) {
			try {
				
				wait();
				//System.out.println("��ʼ����");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"������ȡ���˵�" + this.procuct + "����Ʒ");
		this.procuct--;
		notifyAll();
	}

	public synchronized void product() {
		if (this.procuct >= 10) {
			try {
				
				wait();
				//System.out.println("�ָ�����");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.procuct++;
		System.out.println(Thread.currentThread().getName()+"������������" + this.procuct + "����Ʒ");
		notifyAll();
	}
}

public class ConsumerAndProducer {
	public static void main(String[] args) {
		Consumer con = new Consumer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					con.consume();
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200; i++) {
					con.product();
				}
			}
		}).start();
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 200; i++) {
//					con.product();
//				}
//			}
//		}).start();
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 200; i++) {
//					con.consume();
//				}
//			}
//		}).start();
	}
}
