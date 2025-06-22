package collections.sortingObjects;
import java.util.Set;
import java.util.TreeSet;

public class Test {

    /**
     * A main method that demonstrates the use of a TreeSet to store and traverse
     * a collection of Employee objects in a sorted order.
     * <p>
     * This program adds 4 Employee objects to a TreeSet, and then prints out the
     * contents of the TreeSet in sorted order.
     * <p>
     * By comparing the two outputs, the user can see the effects of the TreeSet
     * class, which is that it stores elements in a sorted order, and
     * automatically removes all duplicate elements from a collection.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Set<Employee> test = new TreeSet<Employee>(new EmployeeNameComparator());

        test.add(new Employee(1,"Gourav"));
        test.add(new Employee(3,"Test"));
        test.add(new Employee(2,"Amit"));
        test.add(new Employee(4,"Best"));

        for( Employee e : test){
            System.out.println(e.id + " " + e.name);
        }

    }
}
