package cn.zhangcf.demo;

//数据要想完整操作必须使用同步，但是过多的同步会导致死锁。
//此处解决的办法就是result()中撤销一个synchronized关键字。
class Pen{
	public synchronized void get(Note note){
		System.out.println("我想得到本！");
		note.result();
	}
	public synchronized void result(){
		System.out.println("写作业！");
	}
}
class Note{
	public synchronized void get(Pen pen){
		System.out.println("我想得到笔！");
		pen.result();
	}
	public synchronized void result(){
		System.out.println("为了记笔记！");
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
