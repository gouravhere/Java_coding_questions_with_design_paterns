package multiThreading.synchronization.classLock;

public class DisplayMessage {

    public synchronized static void printMessage(String name) {
        for(int i = 0; i < 5; i++)
            System.out.println("Executing Synchronized Method "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
