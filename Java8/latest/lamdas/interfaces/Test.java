package Java8.latest.lamdas.interfaces;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //Normal apporach -
//        Runnable r = new MyRunnable();
//        Thread thread = new Thread(r);
//        thread.start();

        //Using lambda
        Runnable r = ()->{
            for(int i =0 ; i<10 ; i ++){
                System.out.println("Lambda thread " + i);
            }
        };
                Thread thread = new Thread(r);
                thread.start();

        for(int i = 0; i<10; i ++){
            System.out.println("Test method i is "+i);
        }
    }
}
