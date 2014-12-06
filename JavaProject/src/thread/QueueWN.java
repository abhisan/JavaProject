package thread;

class QueueWN {
	private int num;
	private boolean valueSet = false;

	synchronized void put(int n) {
		while (valueSet) {
			try {
				wait();
			} catch (InterruptedException err) {
				System.out.println("put() interrupted.");
			}
		}
		num = n;
		valueSet = true;
		notify();
		System.out.println("Put: " + n);
	}

	synchronized int get() {
		while (!valueSet) {
			try {
				wait();
			} catch (InterruptedException err) {
				System.out.println("get() interrupted.");
			}
		}
		valueSet = false;
		notify();
		System.out.println("Got: " + num);
		return num;
	}
}