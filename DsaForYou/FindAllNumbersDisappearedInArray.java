package DsaForYou;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInArray {
    public static void main(String [] args){

        int [] nums = {5,6,4,4,2,1,2};
        Set<Integer> seen = new HashSet<Integer>();
        for(int num : nums){
            seen.add(num);
        }
        List<Integer> missing = new ArrayList<>();
        for(int i = 1; i <=nums.length;i++){
            if(!seen.contains(i)){
                missing.add(i);
            }
        }
        System.out.println(missing);
    }

}
