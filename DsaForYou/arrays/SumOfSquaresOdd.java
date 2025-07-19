package DsaForYou.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfSquaresOdd {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6);

        int sum = l1.stream().filter(i->i%2!=0).map(i->i*i).reduce(0,Integer::sum);
        System.out.println(sum);
    }
}
