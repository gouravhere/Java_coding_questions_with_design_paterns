package collections.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    /**
     * This main method demonstrates the following operations on an ArrayList:
     *     - Adding elements
     *     - Adding an element at a specific index
     *     - Setting an element at a specific index
     *     - Adding all elements of a second list at a specific index
     *     - Checking if a list contains a specific element
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> ad = new ArrayList<Integer>();
       for(int i=0;i<10;i++){
           ad.add(i*10);
       }
        System.out.println("Before adding 2nd element "+ad);
        ad.add(2,100);
        System.out.println("After adding 100 after 2nd element "+ad);
        ad.set(3,900);
        System.out.println("After replacing 3rd element "+ad);
        
        List<Integer> second = new ArrayList<Integer>();
        for(int j=0;j<10;j++){
            second.add(j*10);
        }
        System.out.println("Second list: " + second);

        ad.addAll(2,second);
        System.out.println("After adding second list "+ad);

        if(ad.contains(100)){
            System.out.println("Contains 100");
        }
        else{
            System.out.println("Does not contain 100");
        }
    }
}
