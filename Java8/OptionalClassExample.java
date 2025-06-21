package Java8;

import java.util.Optional;

public class OptionalClassExample {
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
