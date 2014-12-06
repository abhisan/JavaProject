package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class FinishTask {
	public static void main(String s[]) {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(3);

		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						startGate.await();
						// do task;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					finally{
						endGate.countDown();
					}
				}
			}).start();
		}
		startGate.countDown();
		try {
			endGate.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
