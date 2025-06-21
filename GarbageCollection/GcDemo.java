package GarbageCollection;

public class GcDemo {
        int objId;
    GcDemo(int objId) {
        this.objId = objId;
        System.out.println(this + "Constructor called");
    }
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * This main method creates a few objects and then
     * calls System.gc() 100 times. This is just a
     * demonstration of how finalize() is called when
     * the garbage collector is run.
     */
/* <<<<<<<<<<  7336c743-2895-4583-a9ad-d531b03fa96b  >>>>>>>>>>> */
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
