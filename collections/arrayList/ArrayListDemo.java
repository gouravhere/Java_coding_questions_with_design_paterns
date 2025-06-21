package collections.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
    /**
     * A demonstration of using an ArrayList to store and manipulate a list of elements.
     * The example shows how to create an ArrayList, add elements to it, and modify them.
     * It also shows how to check if the list contains a certain element, and how to
     * iterate over the elements of the list using an Iterator.
     * @param args the command line arguments
     */
/* <<<<<<<<<<  e6e68648-50aa-4495-938a-6e4db98d205c  >>>>>>>>>>> */
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
        Iterator<Integer> iterator = ad.iterator(); // <Integer>
        while(iterator.hasNext()){
            System.out.println("Printed using iterator "+ iterator.next());
        }
    }
}
