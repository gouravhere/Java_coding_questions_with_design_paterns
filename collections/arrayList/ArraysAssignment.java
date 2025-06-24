package collections.arrayList;

import java.util.Arrays;

public class ArraysAssignment {
    public static void main(String[] args) {

        String[] arr = {"V","A","Z","P"};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, "Z");
        if(index>=0){
            System.out.println("Element found at index " + index);
        }
        else{
            System.out.println("Element not found. It would be inserted at index " + (-index-1));
        }
    }
}
