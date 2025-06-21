package multiThreading.synchronization.blocks;

public class DisplayMessage {

    public void printMessage(String name) {
        //Other Two ways
       // synchronized (DisplayMessage.class) {
        //synchronized (new String(abc)) {
        System.out.println("Before sync block");
            synchronized (this) {
                for(int i = 0; i < 5; i++)
                    System.out.println("Executing Synchronized Method "+name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
