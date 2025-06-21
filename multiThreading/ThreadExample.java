package multiThreading;


class Task1 extends Thread{
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
/**
 * The run method is executed when the thread is started.
 * It iterates through numbers from 0 to 10 and prints each number
 * followed by a space to the console.
 */

/* <<<<<<<<<<  77be0fbc-ddd6-416f-9c0d-1195350ea85f  >>>>>>>>>>> */
	public void run() {
		for(int i = 0 ; i <11 ; i++) {
			System.out.print(i+" ");
		}
	}
}
class Task2 implements Runnable{

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Prints numbers from 11 to 21 (inclusive) to the console,
	 * each followed by a space.
	 */
/* <<<<<<<<<<  b6111e17-5eb1-4be4-b7d5-2bbabf49f0db  >>>>>>>>>>> */
	@Override
	public void run() {
		for(int i = 11 ; i <22 ; i++) {
			System.out.print(i+" ");
		}
		
	}
	
}
public class ThreadExample {

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Creates two threads, {@code thread1} and {@code thread}.
	 * The first one is an instance of {@link Task1} and the second one runs
	 * a {@link Task2} instance.
	 *
	 * The threads are started in order and the main thread waits for their
	 * completion.
	 *
	 * @param args the command line arguments
	 * @throws InterruptedException if the current thread is interrupted
	 */
/* <<<<<<<<<<  84374284-237c-46f5-8d06-4042a8a7c2f5  >>>>>>>>>>> */
	public static void main(String[] args) throws InterruptedException {
		
		Task1 thread1 = new Task1();
		//thread1.setPriority(10);  --- For setting the Priority  1- min , 5 - normal , 10 - max {may or maynot be considered}
		thread1.start();
		//thread1.join();//waiting for this thread to die before starting second one
		
		//Task1.yield();//A hint to the scheduler that the current thread is willing to yield its current use of a processor. 
					//The scheduler is free to ignore this hint.
		
		Task2 task2 = new Task2();
		Thread thread = new Thread(task2);
		thread.start();
		

	}

}
