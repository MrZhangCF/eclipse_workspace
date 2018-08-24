package cn.zhangcf.demo;

//volatile关键字的使用区别：
//未使用volatile关键字定义的变量，则操作的时候使用的是副本进行的处理，副本和原始数据
//之间的同步就会产生延迟，所谓的线程的不同步也就在于此
//volatile关键字定义的变量表示将直接使用原始数据进行处理，更改后直接生效。

class Singleton {
	private volatile static Singleton instance;

	private Singleton() {
		System.out.println("【构造方法】" + Thread.currentThread().getName());
	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

public class VolatileKeyword {
	public static void main(String[] args) {
		new Thread(() -> Singleton.getInstance(), "线程A").start();
		new Thread(() -> Singleton.getInstance(), "线程B").start();
		new Thread(() -> Singleton.getInstance(), "线程C").start();
		new Thread(() -> Singleton.getInstance(), "线程D").start();
		new Thread(() -> Singleton.getInstance(), "线程E").start();
		// 执行上述的代码发现单例设计模式并不是单例
		// 第一种方法：可以在Singleton类中的getInstance()方法前加上synchronized关键字
		// 第二种方法：如上
	}
}
