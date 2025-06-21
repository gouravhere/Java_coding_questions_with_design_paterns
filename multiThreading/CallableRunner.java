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
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Computes a greeting message after a delay.
	 *
	 * @return A greeting message that includes the name provided during task initialization.
	 * @throws Exception if the thread is interrupted while sleeping.
	 */

/* <<<<<<<<<<  e4a8c42a-8680-4862-920a-8de784d8ee30  >>>>>>>>>>> */
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Hello "+name;
	}
	
}


public class CallableRunner {
	
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * The main method demonstrates the use of an ExecutorService to execute Callable tasks
     * and retrieve results. It submits a single Callable task that returns a greeting message
     * and prints the result. It then creates a list of Callable tasks and uses
     * `invokeAny` to execute all tasks, printing the result of the fastest task to complete.
     * Finally, it shuts down the executor service.
     *
     * @param args command line arguments
     * @throws InterruptedException if the current thread was interrupted while waiting
     * @throws ExecutionException if the computation threw an exception
     */

/* <<<<<<<<<<  efa408ef-2449-4168-9404-5a512996f6bb  >>>>>>>>>>> */
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
