package multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	
	
	public static void main(String[] args) throws InterruptedException {
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(2);//to set number of threads to execute in one time
		executorService.execute(new Task1());
		executorService.execute(new Thread(new Task2()));
		
		executorService.shutdown();
	}
}
