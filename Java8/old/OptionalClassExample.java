package Java8.old;

import java.util.Optional;

public class OptionalClassExample {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * A main method that demonstrates the use of the `Optional` class, as well as a
	 * traditional, non-`Optional` method.
	 */
/* <<<<<<<<<<  a8c482ff-2260-46d4-850c-d37253aed700  >>>>>>>>>>> */
	public static void main(String[] args) {
		Optional<String> number = example(null);
		System.out.println("testing optional "+ number);
		
		String Reference = example1(2);
		System.out.println("testing optional "+ Reference);
		
	}
// using optional class
	public static Optional<String> example(String A){
		String a1 =null;
		
		return Optional.ofNullable(a1);
		
	}
	//old implementation
	public static String example1(int A){
		return null;
		
	}
}
