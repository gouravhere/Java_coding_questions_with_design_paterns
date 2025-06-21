package collections.set;

import java.util.*;

public class HasSetDemo {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * A main method that demonstrates the differences between a List and a Set.
     * <p>
     * This program creates a List of 10 random integers, each between 0 and 4 inclusive.
     * It then prints the contents of the List to the console.
     * <p>
     * After that, it creates a new Set from the List, and prints the contents of the Set
     * to the console.
     * <p>
     * By comparing the two outputs, the user can see the effects of the Set interface,
     * which is that it removes all duplicate elements from a collection.
     * @param args command line arguments (not used)
     */
/* <<<<<<<<<<  80749da6-409d-42c9-b302-d0d9425ff457  >>>>>>>>>>> */
    public static void main(String[] args) {
        Random random = new Random();
        List<Object> objects = new ArrayList<Object>();
        for (int i = 0; i < 10; i++) {
            objects.add(random.nextInt(100));
        }
        System.out.println("ArrayList Data" + objects);
        Set<Object> set = new HashSet<Object>(objects);
        System.out.println("Set Data"+set);

    }
}
