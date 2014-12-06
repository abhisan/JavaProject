package thread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
	public static void main(String s[]) {
		BlockingQueue<Job> bq = new ArrayBlockingQueue<Job>(1024);
		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);
		new Thread(producer).start();
        new Thread(consumer).start();
	}
}

class Producer implements Runnable {

	protected BlockingQueue<Job> queue = null;

	public Producer(BlockingQueue<Job> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.put(new Job(1));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue<Job> queue = null;

	public Consumer(BlockingQueue<Job> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class Job {
	private Integer jobId;

	public Job(Integer jobId) {
		this.jobId = jobId;
	}

	public void execute() {
		System.out.println(jobId);
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + "]";
	}
}
