package cn.zhangcf.demo;

//����Ҫ��������������ʹ��ͬ�������ǹ����ͬ���ᵼ��������
//�˴�����İ취����result()�г���һ��synchronized�ؼ��֡�
class Pen{
	public synchronized void get(Note note){
		System.out.println("����õ�����");
		note.result();
	}
	public synchronized void result(){
		System.out.println("д��ҵ��");
	}
}
class Note{
	public synchronized void get(Pen pen){
		System.out.println("����õ��ʣ�");
		pen.result();
	}
	public synchronized void result(){
		System.out.println("Ϊ�˼Ǳʼǣ�");
	}
}
public class MyThread7 implements Runnable{
	private static Pen pen  = new Pen();
	private static Note note = new Note();
	public static void main(String[] args) {
		new MyThread7();
	}
	public MyThread7(){
		new Thread(this).start();
		pen.get(note);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		note.get(pen);
	}
	
	
}
