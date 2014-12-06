package thread;

import java.util.concurrent.Semaphore;

class QueueSem {
	private int num;

	private final static Semaphore semCon = new Semaphore(0);
	private final static Semaphore semPro = new Semaphore(1);

	void put(int n) {
		try {
			semPro.acquire();
		} catch (InterruptedException err) {
			System.out.println("put() interrupted.");
			// semPro.release();
		} finally {

		}
		num = n;
		semCon.release();
		System.out.println("Put: " + n);
	}

	int get() {
		try {
			semCon.acquire();
		} catch (InterruptedException err) {
			System.out.println("get() interrupted.");
			// semCon.release();
		} finally {

		}
		semPro.release();
		System.out.println("Got: " + num);
		return num;
	}
}