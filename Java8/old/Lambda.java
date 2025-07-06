package Java8.old;



/*
 * 
 * Lambda Expressions were added in Java 8.
 * 
 * Its an anonymous expression 

A lambda expression is a short block of code which takes in parameters and returns a value. 
Lambda expressions are similar to methods, but they do not need a name and 
they can be implemented right in the body of a method.

parameter -> expression

 */
public class Lambda {
	public static void main(String args[]){
		int a = 10;
		int b = 15;
		//lambda expression
		SumInterface sum = ()-> a + b; System.out.println(sum.add());
		
		//below is the use of default method in interface
		Example p =new Example();
		p.Example1();
	}
	

	//1.functional interface can have only 1 abstract method, it can have multiple static or default methods.
	//2.We can extend a functional interface method but the parent or child should have 1 abstract method.
	
	// Define a functional interface for the sum operation
	@FunctionalInterface
	interface SumInterface {
	    int add();
	}
	
}

/*Interfaces -- Default and Static
 * 1. Default method in interface
 * --Methods with body
 */

//Example 1 -- Basic usage of default methods in interfaces
interface Parent{
	default void Example(){
		System.out.println("Inside Parent");
		
	}
}

class Child implements Parent{
	//If this is empty then it will refer the interface Parent.
	//otherwise we can over ride new method
	@Override
	public void Example() {
		System.out.println("Inside Child");
	}
	
}

//Example 2 -- If we have two interfaces and user implements both in same class then we will get error or not , if yes then why and fix.
interface A{
	default void Example1() {
		System.out.println("Inside A");
	}
}

interface B{
	default void Example1() {
		System.out.println("Inside B");
	}
}

//Answer - Yes it will throw error - Duplicate default methods named Example with the parameters () and () are inherited from the types B and A
//class Example implements A,B{}<--Like this
//Fix -
class Example implements A,B{
//override any one
	@Override
	public void Example1() {
		B.super.Example1();
		A.super.Example1();	}
	
}
/*
 * 2. Static method in interface
 * --Methods with Static Keywords
 * -- With body
 * -- Can not be overridden ---- implementation class can not access or see static methods
 * -- we can not call them using obj.<interface method name>. It can only be called using <interface name>.<method name>
 * 
 */

//Example 
interface C{
	static void test() {
		
	}
}