package multiThreading.synchronization.classLock;

public class SyncDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Gourav");
        MyThread thread2 = new MyThread("Sharma");
        thread1.start();
        thread2.start();
    }
}
