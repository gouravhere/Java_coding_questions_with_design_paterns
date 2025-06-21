package multiThreading.synchronization;

public class DisplayMessage {

    public synchronized void printMessage(String message) {
        for(int i = 0; i < 5; i++)
            System.out.println("Executing Synchronized Method "+message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
