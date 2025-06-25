package collections.generics;

public class MyCustomGeneric<T> {

    T obj;
    MyCustomGeneric(T obj){
        this.obj = obj;
    }

    /**
     * Prints the class name of the object stored in this generic class.
     * This method provides a way to display the runtime type information
     * of the object held by the generic instance.
     */
    public void getDisplayObj(){
        System.out.println("It is of type : " +obj.getClass().getName());
    }
    public T getObj(){
        return obj;
    }

}
