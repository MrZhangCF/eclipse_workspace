package concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Test_8 {
	public static void main(String[] args) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		final Runnable beeper = new Runnable() {
			int count = 0;

			public void run() {
				System.out.println(new Date() + " beep " + (++count));
			}
		};

		// 1���Ӻ����У���ÿ��2������һ��
		final ScheduledFuture beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 2, TimeUnit.SECONDS);
		// 2���Ӻ����У���ÿ�����ϴ������������ȴ�5�����������
		//final ScheduledFuture beeperHandle2 = scheduler.scheduleWithFixedDelay(beeper, 2, 5, TimeUnit.SECONDS);
		// 30�������ر����񣬲��ҹر�Scheduler
		scheduler.schedule(new Runnable() {
			public void run() {
				beeperHandle.cancel(true);
			//	beeperHandle2.cancel(true);
				scheduler.shutdown();
			}

		}, 30, TimeUnit.SECONDS);

	}
}
