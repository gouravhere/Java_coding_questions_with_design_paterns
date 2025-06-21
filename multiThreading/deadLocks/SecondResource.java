package multiThreading.deadLocks;

public class SecondResource {
    public synchronized void method1(FirstResource firstResource){
        System.out.println("method1 of SecondResource");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("invoking method2 of FirstResource");
        firstResource.method2();
    }
    public synchronized void method2(){
        System.out.println("method2 of SecondResource");
    }
}
