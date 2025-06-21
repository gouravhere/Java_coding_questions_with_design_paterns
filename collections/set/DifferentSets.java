package collections.set;

import java.util.*;

public class DifferentSets {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Demonstrates the behavior of different Set implementations in Java: HashSet, LinkedHashSet, and TreeSet.
     *
     * <p>
     * This method generates and adds 10 random integers (between 0 and 99) to each type of Set.
     * It prints each number as it is added and then prints the contents of each Set.
     * </p>
     *
     * <p>
     * - HashSet: Does not maintain any order of elements.
     * - LinkedHashSet: Maintains insertion order of elements.
     * - TreeSet: Maintains natural ordering of elements.
     * </p>
     *
     * @param args command line arguments (not used)
     */

/* <<<<<<<<<<  97abe92b-31e0-4779-bbd3-1ed290b50280  >>>>>>>>>>> */
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            hashSet.add(num);
            System.out.println("Random number added to hashSet: " + num);
        }
        System.out.println("hashSet: " + hashSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            linkedHashSet.add(num);
            System.out.println("Random number added to linkedHashSet: " + num);
        }
        System.out.println("linkedHashSet: " + linkedHashSet);
        Set<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            treeSet.add(num);
            System.out.println("Random number added to treeSet: " + num);
        }
        System.out.println("treeSet: " + treeSet);

//        Iterator<Integer> iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
