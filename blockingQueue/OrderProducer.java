package blockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {

    private BlockingQueue<String> orderQueue;

    public OrderProducer(BlockingQueue<String> orderQueue) {
        this.orderQueue = orderQueue;
    }
    /**
     * This method is overridden from the Runnable interface and is called
     * when the thread is started. It attempts to put a series of orders
     * into the blocking queue. If an InterruptedException occurs during
     * this process, it catches the exception and prints it to the console.
     */
    @Override
    public void run() {
        try{
        orderQueue.put("Order 1");
        orderQueue.put("Order 2");
        orderQueue.put("Order 3");
        orderQueue.put("Order 4");
        orderQueue.put("Order 5");
        }
        catch(InterruptedException e){
            System.out.println("Exception is "+e);
        }

    }
}
