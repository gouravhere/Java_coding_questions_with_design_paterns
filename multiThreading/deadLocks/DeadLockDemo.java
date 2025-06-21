package multiThreading.deadLocks;

public class DeadLockDemo implements Runnable{

    FirstResource firstResource = new FirstResource();
    SecondResource secondResource = new SecondResource();
    public DeadLockDemo() {
    new Thread(this).start();
    secondResource.method1(firstResource);//this will result in deadlock
    }
    public static void main(String[] args) {
            new DeadLockDemo();
    }

    @Override
    public void run() {
        firstResource.method1(secondResource);
    }
}
