package EqualAndHashCodeContract;

public class Main {
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
