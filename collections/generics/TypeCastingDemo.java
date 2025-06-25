package collections.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeCastingDemo {
    /**
     * A demonstration of using generics to prevent ClassCastException. The example
     * shows how to create a list of strings, add elements to it, and retrieve them
     * without having to perform explicit casting. It also shows how attempting to
     * add an integer to the list will result in a compilation error, thanks to the
     * use of generics.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Gourav");
        list.add("Sourav");
        //list.add(10); // this will give error "Class cast Exception" because we are adding int into a list of string
                        //So to prevent this we use generics
        String name = (String) list.get(0);
        String name2 = (String) list.get(1);
        System.out.println(name);
        System.out.println(name2);
       // String name3 = (String) list.get(2);


        //Using Custom Generic
        MyCustomGeneric<String> myCustomGeneric = new MyCustomGeneric<>("Gourav");
        System.out.println(myCustomGeneric.getObj());

        MyCustomGeneric<Integer> myCustomGeneric2 = new MyCustomGeneric<>(10);
        System.out.println(myCustomGeneric2.getObj());

        MyCustomGeneric<Double> myCustomGeneric3 = new MyCustomGeneric<>(10.0);
        System.out.println(myCustomGeneric3.getObj());

    }
}
