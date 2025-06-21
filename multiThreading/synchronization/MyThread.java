package multiThreading.synchronization;

public class MyThread extends Thread {
    DisplayMessage message;
    String name ;

    public MyThread(DisplayMessage message, String name) {
        this.message = message;
        this.name = name;
    }

    public void run() {
        message.printMessage(name);
    }
}
