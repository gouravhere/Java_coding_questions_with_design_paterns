package basicJava;

public class Test {
	public static void main (String [] args) {
	Parent parent1 = new Example();
	Parent parent2 = new Example2();
//	parent1.one(22);
//	parent2.one();
	//parent1.one(10, 20); //method overloading
	// below is example of runtime poly method overriding
//	parent1.poly();
//	parent2.poly();
	sum();
}
	
	public static void sum() {
		int num = 5;
		int sum = 0;
		for(int i = 1; i <=num ; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
	}
}
