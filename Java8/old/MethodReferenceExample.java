package Java8.old;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Print the given string as a list element.
	 * @param s the element to print.
	 */
/* <<<<<<<<<<  c5782f79-704b-4bea-8164-345516a2c887  >>>>>>>>>>> */
	public static void print(String s) {
		System.out.println("List Contains " + s);
		
	}
	
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
	/**
	 * Prints the elements of a list using a method reference.
	 *
	 * <p>This example shows how to use a method reference to print the elements of a
	 * list.
	 *
	 * @param args the command line arguments
	 */
/* <<<<<<<<<<  752a57ba-083b-48a3-8ba5-f7801f0fc56b  >>>>>>>>>>> */
	public static void main (String args[]) {
		List <String> MR = Arrays.asList("Gourav","Sourav","NoName");
		//below line shows usage of lambda expression
		//MR.forEach(x-> System.out.println(x))
//Above lambda expression was replaced by method reference using <className :: method name> without evoking method
		MR.forEach(MethodReferenceExample::print);
	}
}
