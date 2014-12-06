package thread;

class PrintEventOddVer2 {
	public int i = 1;
	public int size;
	public boolean odd = true;

	public PrintEventOddVer2(int _size) {
		this.size = _size;
	}

	public synchronized void printOdd() throws InterruptedException {
		while (i <= size) {
			if (!odd) {
				this.wait();
			}
			System.out.println("odd" + i);
			i++;
			notify();
			odd = false;
		}
	}

	public synchronized void printEven() throws InterruptedException {
		while (i <= size) {
			if (odd) {
				this.wait();
			}
			System.out.println("even" + i);
			i++;
			notify();
			odd = true;
		}
	}
}

public class TestPrintEventOddVer2 {
	public static void main(String s[]) {
		PrintEventOddVer2 peo = new PrintEventOddVer2(100);
		new Thread(new Runnable() {
			public void run() {
				try {
					peo.printOdd();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				try {
					peo.printEven();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}