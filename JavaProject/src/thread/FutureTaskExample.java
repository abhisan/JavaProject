package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(
			new Callable<ProductInfo>() {
				public ProductInfo call() throws DataLoadException {
					return loadProductInfo();
				}

				private ProductInfo loadProductInfo() {
					// TODO Auto-generated method stub
					return null;
				}
			});
	private final Thread thread = new Thread(future);

	public void start() {
		thread.start();
	}

	public ProductInfo get() throws DataLoadException, InterruptedException {
		try {
			return future.get();
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			if (cause instanceof DataLoadException)
				throw (DataLoadException) cause;
			else
				throw launderThrowable(cause);
		}
	}

	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("Not unchecked", t);
	}
}

class DataLoadException extends Exception {
	private static final long serialVersionUID = 1L;

	DataLoadException() {
		super("DataLoadException");
	}
}

class ProductInfo {

}