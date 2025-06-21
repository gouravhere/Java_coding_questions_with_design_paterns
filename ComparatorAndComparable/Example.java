package ComparatorAndComparable;

import java.util.Arrays;
import java.util.Comparator;

public class Example {
/* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */
/**
 * The main method demonstrates sorting operations using both arrays and custom objects.
 *
 * It performs the following tasks:
 * 1. Sorts an integer array using the traditional Arrays.sort method and prints the sorted array.
 * 2. Creates an array of Employee objects and sorts them using:
 *    - The Comparable interface for natural sorting by employee ID.
 *    - A custom Comparator for sorting by employee name.
 *
 * @param args the command line arguments (not used in this method)
 */

/* <<<<<<<<<<  58c5ea8e-a163-40b8-8c82-9570c82f6981  >>>>>>>>>>> */
public static void main (String [] args) {
	//Traditional way to sort 
	int arr[] = {1,3,4,2,6,5};
	 Arrays.sort(arr);
	System.out.println("Sorted array " +Arrays.toString(arr));
	
	
	//created array to check Comparable example
	Employee[] empArr = new Employee [4];
	empArr[0]=  new Employee(2,"Gourav");
	empArr[1]=  new Employee(1,"Amit");
	empArr[2]=  new Employee(7,"Test");
	empArr[3]=  new Employee(4,"Best");
	
	Arrays.sort(empArr); //---- use for natural sorting --comparable 
	System.out.println("Sorted Array using Comparable " +Arrays.toString(empArr));
	Arrays.sort(empArr,Employee.CompaEmp); // ---- using Comparator
	System.out.println("Sorted Array using Comparator " +Arrays.toString(empArr));
	
	
	
}

		
	

}

//below is example of Comparable
class Employee implements Comparable<Employee>{

	private int id;
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	
	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return this.id - emp.id;
	}
	
	//below is Comparator implementation 
	
	public static Comparator<Employee> CompaEmp = new Comparator<Employee> () {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	};
		
	
}