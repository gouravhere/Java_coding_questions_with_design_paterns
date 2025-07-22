package DsaForYou.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromePossible {
    public static void main(String[] args) {
        String s = "racecar";
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i<s.length(); i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            else{
                set.remove(s.charAt(i));
            }
        }
        System.out.println(set.isEmpty() || set.size()<=1? true : false);
    }

}
