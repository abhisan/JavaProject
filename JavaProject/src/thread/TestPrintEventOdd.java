package thread;

import java.util.concurrent.Semaphore;

class PrintEventOdd {
	public int i = 1;
	public int size;
	public Semaphore odd = new Semaphore(1);
	public Semaphore even = new Semaphore(1);

	public PrintEventOdd(int _size) {
		this.size = _size;
		try {
			// odd.acquire();
			even.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printOdd() throws InterruptedException {
		while (i <= size) {
			odd.acquire();
			System.out.println("odd" + i);
			i++;
			// odd.release();
			even.release();
		}
	}

	public void printEven() throws InterruptedException {
		while (i <= size) {
			even.acquire();
			System.out.println("even" + i);
			i++;
			odd.release();
		}
	}
}

public class TestPrintEventOdd {
	public static void main(String s[]) {
		PrintEventOdd peo = new PrintEventOdd(100);
		new Thread(new Runnable() {
			public void run() {
				try {
					peo.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				try {
					peo.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}