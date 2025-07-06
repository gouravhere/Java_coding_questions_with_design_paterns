package Java8.latest.lamdas.interfaces;

public class UsingAnonymus {
    public static void main(String[] args){
        Thread t = new Thread(()->{
            for (int i =0;i<10;i++){
                System.out.println("Child Thread"+i);
            }
        });
        t.start();
    }

}
