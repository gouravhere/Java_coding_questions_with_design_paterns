package Java8.latest.lamdas.interfaces;

public class MyRunnable implements  Runnable{

    @Override
    public void run() {
        for(int i =0; i<10; i++){
            System.out.println("My Runnable i is : " +i);
        }

    }
}
