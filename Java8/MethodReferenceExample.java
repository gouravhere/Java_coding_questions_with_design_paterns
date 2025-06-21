package Java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

	public static void print(String s) {
		System.out.println("List Contains " + s);
		
	}
	
	public static void main (String args[]) {
		List <String> MR = Arrays.asList("Gourav","Sourav","NoName");
		//below line shows usage of lambda expression
		//MR.forEach(x-> System.out.println(x))
//Above lambda expression was replaced by method reference using <className :: method name> without evoking method
		MR.forEach(MethodReferenceExample::print);
	}
}
