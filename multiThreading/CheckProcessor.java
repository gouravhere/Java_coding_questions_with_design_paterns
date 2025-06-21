package multiThreading;

public class CheckProcessor implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
public static void main(String[] args) {
    Thread thread = new Thread(new CheckProcessor());
    thread.start();
   //For interrupting--- thread.interrupt();
}
}
