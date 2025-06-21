package multiThreading.daemon;

public class DaemonDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isDaemon());
        MyThread thread = new MyThread();
        thread.setDaemon(true);//Setting thread as daemon thread by using setDaemon(true) method
        System.out.println(thread.isDaemon());
        thread.start();
    }
}
