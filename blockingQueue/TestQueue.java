package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueue {
    /**
     * This is the main method of the class, and it is the entry point of the
     * program. This method creates an ArrayBlockingQueue of size 1024 and two
     * objects of OrderProducer and OrderConsumer. It creates two threads and
     * starts them. The first thread is the producer and the second thread is
     * the consumer. The producer puts elements in the blocking queue and the
     * consumer takes elements from the blocking queue.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlockingQueue<String> orderQueue = new ArrayBlockingQueue<String>(1024);
        OrderProducer orderProducer = new OrderProducer(orderQueue);
        OrderConsumer orderConsumer = new OrderConsumer(orderQueue);
        Thread producerThread = new Thread(orderProducer);
        Thread consumerThread = new Thread(orderConsumer);
        producerThread.start();
        consumerThread.start();
    }
}
