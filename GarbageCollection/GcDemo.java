package GarbageCollection;

public class GcDemo {
        int objId;
    GcDemo(int objId) {
        this.objId = objId;
        System.out.println(this + "Constructor called");
    }
    public static void main(String[] args) {
        new GcDemo(1);
        new GcDemo(2);
        new GcDemo(3);
       for(int i = 0; i < 100; i++) {
           System.gc();
       }
    }

    @Override
    public void finalize() {
        System.out.println(this + "Finalize called" + objId);
    }
}
