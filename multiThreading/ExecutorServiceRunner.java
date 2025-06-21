package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	
	
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * The main method demonstrates the use of ExecutorService to execute tasks concurrently.
     * It creates a fixed thread pool with two threads and submits two tasks for execution.
     *
     * @param args command line arguments (not used)
     * @throws InterruptedException if the current thread is interrupted while waiting
     */

/* <<<<<<<<<<  701ab921-2f3d-4171-9b60-c2521d273d0d  >>>>>>>>>>> */
	public static void main(String[] args) throws InterruptedException {
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(2);//to set number of threads to execute in one time
		executorService.execute(new Task1());
		executorService.execute(new Thread(new Task2()));
		
		executorService.shutdown();
	}
}
