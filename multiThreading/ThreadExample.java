package multiThreading;


class Task1 extends Thread{
	public void run() {
		for(int i = 0 ; i <11 ; i++) {
			System.out.print(i+" ");
		}
	}
}
class Task2 implements Runnable{

	@Override
	public void run() {
		for(int i = 11 ; i <22 ; i++) {
			System.out.print(i+" ");
		}
		
	}
	
}
public class ThreadExample {

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
