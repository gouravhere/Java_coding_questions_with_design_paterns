package collections.sortingObjects;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{
    int id;
    String name;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Employee o) {
        int id1 = this.id;
        int id2 = o.id;

        if(id1<id2){
            return 1;
        }else if(id1>id2){
            return -1;
        }else{
            return 0;
        }
    }
}
