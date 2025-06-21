package Java8;

import java.util.function.Predicate;


//Predicate is a function which returns boolean value.
public class PredicateExample {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Examples of using Predicates to return a boolean value.
	 *
	 * First example: return true if value > 10
	 * Second example: return true if first letter contains "g"
	 * Third example: return true if last letter contains "v"
	 */
/* <<<<<<<<<<  7a4cedd6-3171-4874-aa24-1bc926f86bdf  >>>>>>>>>>> */
	public static void main (String args[]) {
		//To return true if value > then 10
		Predicate<Integer> Test = x -> x > 10;
		System.out.println(Test.test(11));
		
		//To return true if first letter contains "g"
		Predicate<String> CheckFirstLetter = y -> y.toLowerCase().charAt(0) == 'g';
		System.out.println(CheckFirstLetter.test("Gourav"));
		
		//To return true if last letter contains "v"
				Predicate<String> ChecklastLetter = y -> y.toLowerCase().charAt(y.length()-1) == 'v';
				System.out.println(ChecklastLetter.test("Gourav"));
	}

}
