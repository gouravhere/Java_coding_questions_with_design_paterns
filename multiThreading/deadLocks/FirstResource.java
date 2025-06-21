package multiThreading.deadLocks;

public class FirstResource {

    public synchronized void method1(SecondResource secondResource){
        System.out.println("method1 of FirstResource");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("invoking method2 of SecondResource");
        secondResource.method2();
    }
    public synchronized void method2(){
        System.out.println("method2 of FirstResource");
    }

}
