package collections.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    /**
     * A demonstration of using a PriorityQueue to store and manipulate a list of elements.
     * The example shows how to create a PriorityQueue, add elements to it, and modify them.
     * It also shows how to check if the queue contains a certain element, and how to
     * iterate over the elements of the queue using an Iterator.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i=0;i<10;i++){
            queue.offer(i*10);
        }
        System.out.println("First Queue "+queue);
        System.out.println("Removed "+queue.poll());
        System.out.println("Second Queue "+queue);
        System.out.println("Peek "+queue.peek());
        System.out.println("Third Queue "+queue);
        System.out.println("Removed "+queue.remove());
        System.out.println("Fourth Queue "+queue);
        System.out.println("Element "+queue.element());
        System.out.println("Fifth Queue "+queue);

    }
}
