package demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {

	/**
	 * ͨ����ʹ�ó����ǣ�ĳ�����߳̽ӵ�һ����������n�����߳�����ɣ��������߳���Ҫ�ȴ���n�����̶߳��������֮��ſ�ʼִ�в�����
	 * ��������������Կ�����ǰ��10���߳�ִ�����˳���仯���������һ����ʼ�ջ����������֮��Ż�ִ�С�
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
	 * ���������concurrent���е�Atomicԭ���࣬�����̰߳�ȫ������������
	 * ������Ĳ��Դ���Ľ�����Կ�����û�н�����ͬ������ı����ǵ����Ĵ�������100000��
	 * ��ʹ��Atomic��Ϳ��Ժܺõı�֤�̰߳�ȫ������NonSafeSeq���е�inc����
	 * ǰ����synchronized�ؼ��֣�Ҳ�ɱ�����һ���⡣
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
