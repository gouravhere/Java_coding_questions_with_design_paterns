package multiThreading.synchronization.classLock;

public class MyThread extends Thread {
    String name ;

    public MyThread( String name) {

        this.name = name;
    }

    public void run() {

        DisplayMessage.printMessage(name);
    }
}
