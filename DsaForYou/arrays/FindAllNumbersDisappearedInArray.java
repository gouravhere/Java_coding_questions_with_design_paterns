package DsaForYou.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllNumbersDisappearedInArray {
    public static void main(String [] args){

        int [] nums = {5,6,4,4,2,1,2};
        //Normal way
//        Set<Integer> seen = new HashSet<Integer>();
//        for(int num : nums){
//            seen.add(num);
//        }
//        List<Integer> missing = new ArrayList<>();
//        for(int i = 1; i <=nums.length;i++){
//            if(!seen.contains(i)){
//                missing.add(i);
//            }
//        }
//        System.out.println(missing);

        //Using streams ---

        Set<Integer> seen = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        List<Integer> missing = IntStream.rangeClosed(1,nums.length).
                                filter(i->!seen.contains(i)).boxed().toList();

        System.out.println(missing);
    }

}
