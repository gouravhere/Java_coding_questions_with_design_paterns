package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		// basic approach or imperative approach
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				sum += array[i];
				System.out.println("sum is " + sum);
			}

		}
		// using stream example 1
		int[] array2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int sum2 = Arrays.stream(array2).filter(x -> x % 2 == 0).sum();
		System.out.println("Sum from 2nd " + sum2);

		// using stream example 2
		List<Integer> Example = Arrays.asList(2, 3, 4, 5, 6, 7, 2234, 8, 9, 7, 55, 66, 33, 44, 2, 4);
		List<Integer> FilteredList = Example.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x / 2)
				.distinct()
				.sorted((a,b) -> (b-a))
				.collect(Collectors.toList());
		
		System.out.println("Filterd List using stream " + FilteredList);

		List<Integer> LearningStream = Example.stream()
				.filter(x-> x>=15)
				.collect(Collectors.toList());
		
		System.out.println("new Example "+LearningStream);
	}
	

}

