package demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {

	/**
	 * 通常的使用场景是：某个主线程接到一个任务，起了n个子线程区完成，但是主线程需要等待这n个子线程都完成任务之后才开始执行操作。
	 * 从下面的样例可以看到，前面10个线程执行完成顺序会变化，但是最后一句是始终会在它们完成之后才会执行。
	 */
	public void countDownLatch() {
		int count = 10;
		final CountDownLatch l = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			final int index = i;
			new Thread(new Runnable() {

				@SuppressWarnings("static-access")
				@Override
				public void run() {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread " + index + " has finished...");
					l.countDown();
				}

			}).start();
		}
		try {
			l.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("now all threads have finished");
	}

	
	/**
	 * 这里测试了concurrent包中的Atomic原子类，它是线程安全并且无阻塞的
	 * 从下面的测试代码的结果可以看出，没有进行做同步处理的变量是迭代的次数不是100000次
	 * 而使用Atomic类就可以很好的保证线程安全。若在NonSafeSeq类中的inc方法
	 * 前加上synchronized关键字，也可避免这一问题。
	 */
	public void atomictest(){
		final int loopCount=10000;
		int threadCount=10;
		final NonSafeSeq seq1 = new NonSafeSeq();
		final SafeSeq seq2 = new SafeSeq();
		final SafeSeqWithLock seq3 = new SafeSeqWithLock();
		
		final CountDownLatch l = new CountDownLatch(threadCount);
		for(int i=0;i<threadCount;++i){
			final int index= i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0;j<loopCount;++j){
						seq1.inc();
						seq2.inc();
						seq3.inc();
					}
					System.out.println("finished: "+ index);
					l.countDown();
				}
			}).start();
		}
		try {
			l.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("both have finished");
		System.out.println("NonSafeSeq:"+seq1.get());
		System.out.println("SafeSeq with atomic:"+seq2.get());
		System.out.println("SafeSeq with Lock:"+seq3.get());

	}
	
	class NonSafeSeq{
		private long count=0;
		public void inc(){
			count++;
		}
		public long get(){
			return count;
		}
	}
	class SafeSeqWithLock{
		private long count=0;
		private ReentrantLock lock = new ReentrantLock();
		public void inc(){
			lock.lock();
			count++;
			lock.unlock();
		}
		public long get(){
			return count;
		}
	}
	class SafeSeq{
		private AtomicLong count = new AtomicLong(0);
		public void inc(){
			count.incrementAndGet();
		}
		public long get(){
			return count.longValue();
		}
	}
	public static void main(String[] args) {
		//new CountDownLatchTest().countDownLatch();
		new CountDownLatchTest().atomictest(); 
	}
}
