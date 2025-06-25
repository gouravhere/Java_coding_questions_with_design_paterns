package concurentCollection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public class CopyOnWriteDemo implements Runnable {

    /**
     * This is the body of the thread. It sleeps for 2 seconds and then adds a
     * new element to the list. This is done to check the concurrent modification
     * exception
     */
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception caught");
        }
        list.add("Test");
    }
    public static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
    //Similarly we can use CopyOnWriteArraySet and ConcurrentHashMap

    public static void main(String[] args) throws InterruptedException {

        list.add("Gourav");
        Thread Thread = new Thread(new CopyOnWriteDemo());
        Thread.start();
        list.add("Sourav");
        list.add("NoName");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            Thread.sleep(1000);
        }
        System.out.println("List after adding elements " + list);

    }

}
