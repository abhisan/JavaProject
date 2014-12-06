package thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;


public class TestCallable {
	public static void main(String s[]){
		Callable<Integer> ci = new CallableImpl();
		ExecutorService es = new ScheduledThreadPoolExecutor(5);
		Future<Integer> f = es.submit(ci);
		
		try{
			System.out.println(f.get());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
class CallableImpl implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		return 10;
	}
	
}