package thread.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	public static void main(String s[]){
		ExecutorService executorService = Executors.newFixedThreadPool(10);// ThreadPooledExecutor
		Future<Output> f = executorService.submit(new Callable<Output>(){
			@Override
			public Output call() throws Exception {
				return new Output();
			}
		});
		try {
			f.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class Output{
	
}