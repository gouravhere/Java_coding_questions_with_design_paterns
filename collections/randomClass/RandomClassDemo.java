package collections.randomClass;

import java.util.Random;

public class RandomClassDemo {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * Demonstrates basic usage of the {@link Random} class, by
     * printing out two random integers. The first integer is
     * unrestricted, while the second is between 0 and 99, inclusive.
     *
     * @param args command line arguments (not used)
     */
/* <<<<<<<<<<  457a93e8-e54c-4ff0-88a7-010347a4d551  >>>>>>>>>>> */
    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);
        int y = random.nextInt(100);
        System.out.println(y);
    }
}
