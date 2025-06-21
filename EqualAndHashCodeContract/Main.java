package EqualAndHashCodeContract;

public class Main {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * A test program for verifying the correct implementation of the
	 * {@link Object#equals(Object)} method.
	 *
	 * <p>
	 * This program creates two {@link Employee} objects, sets their fields
	 * to the same values, and then compares them using both the shallow
	 * comparison operator ({@code ==}) and the deep comparison method
	 * ({@link Object#equals(Object)}). The program then prints the results
	 * of both comparisons.
	 * 
	 * <p>
	 * The purpose of this test is to ensure that the {@link Employee} class
	 * has correctly implemented the {@link Object#equals(Object)} method.
	 * If the method has been correctly implemented, the deep comparison
	 * should return true, while the shallow comparison should return false.
	 */
/* <<<<<<<<<<  180e72e0-4407-4e15-93c0-0b437ea80a7b  >>>>>>>>>>> */
	public static void main (String [] args) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		
		e1.setId(1);
		e1.setName("Gourav");
		
		e2.setId(1);
		e2.setName("Gourav");
		
		System.out.println("Shallow Compare "+ (e1==e2));
		System.out.println("Deep Compare " + (e1.equals(e2)));  // without equals method in Employee class this will also return false but after equals method it will return true
		
		
	}
}
