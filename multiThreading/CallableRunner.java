package multiThreading;
import java.util.List;
//Class explains how user can return value using threads
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class callableTask implements Callable<String>{

	private String name;
	public callableTask(String name)
	{
		this.name = name;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello "+name;
	}
	
}


public class CallableRunner {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> message = executorService.submit(new callableTask(" New Task"));//Future means promise like we will have result in later point of time
		
		System.out.println(message.get());//to get the value
		
		//Printing list of threads
		//Create a list of tasks
		List<callableTask> task = List.of(new callableTask("First"),(new callableTask("Second")),(new callableTask("Third")));
		
		//created a list of future 
		//List<Future<String>> results = executorService.invokeAll(task);
		
		//priting the future list
//		for( Future<String> result : results) {
//			System.out.println(result.get());
//		}
		//If you want to print the task which completes first : fastest result
		String result = executorService.invokeAny(task);
		
		System.out.println(result);
		
		
		executorService.shutdown();
		
	}
		
		

}
