package multiThreading.synchronization;

public class SyncDemo {
    public static void main(String[] args) {
        DisplayMessage message = new DisplayMessage();
        MyThread thread1 = new MyThread(message,"Gourav");
        MyThread thread2 = new MyThread(message,"Sharma");
        thread1.start();
        thread2.start();
    }
}
