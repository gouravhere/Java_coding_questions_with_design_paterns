package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class OrderConsumer implements Runnable {

    private BlockingQueue<String> orderQueue;

    public OrderConsumer(BlockingQueue<String> orderQueue) {
        this.orderQueue = orderQueue;
    }
    /**
     * This method is overridden from the Runnable interface and is called
     * when the thread is started. It tries to take all the elements in the
     * blocking queue and prints them to the console. If an InterruptedException
     * occurs, it prints the exception to the console.
     */
    @Override
    public void run() {
        try{
            System.out.println(orderQueue.take());
            System.out.println(orderQueue.take());
            System.out.println(orderQueue.take());
            System.out.println(orderQueue.take());
            System.out.println(orderQueue.take());
        }
        catch(InterruptedException e){
            System.out.println("Exception is "+e);
        }
        
    }
}
