Java Stream API Quick Reference
1. Stream Basics
- Import: import java.util.stream.*;
- Stream creation: list.stream(), Arrays.stream(arr), Stream.of(1, 2, 3)
- Terminal vs Intermediate: Terminal ends the stream (e.g., collect), intermediate is chainable (e.g., filter)
2. Intermediate Operations
- filter(): stream.filter(x -> x > 5)
- map(): stream.map(x -> x * 2)
- sorted(): stream.sorted()
- distinct(): stream.distinct()
- limit(n): stream.limit(n)
- skip(n): stream.skip(n)
- peek(): stream.peek(System.out::println)
3. Terminal Operations
- collect(): stream.collect(Collectors.toList())
- forEach(): stream.forEach(System.out::println)
- toArray(): stream.toArray(Integer[]::new)
- reduce(): stream.reduce(0, Integer::sum)
- count(): stream.count()
- anyMatch(): stream.anyMatch(x -> x > 5)
- allMatch(): stream.allMatch(x -> x > 5)
- noneMatch(): stream.noneMatch(x -> x < 0)
- findFirst(): stream.findFirst().orElse(-1)
- findAny(): stream.findAny().orElse(-1)
4. Common Collectors
- toList(): Collectors.toList()
- toSet(): Collectors.toSet()
- toMap(): Collectors.toMap(x -> x, x -> x*x)
- joining(): Collectors.joining(", ")
- groupingBy(): Collectors.groupingBy(String::length)
- partitioningBy(): Collectors.partitioningBy(x -> x % 2 == 0)
5. Quick Examples
   List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
- Filter evens: nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList())
- Square each: nums.stream().map(n -> n * n).collect(Collectors.toList())
- Sum: nums.stream().reduce(0, Integer::sum)
  Java Stream API Quick Reference
- Count > 3: nums.stream().filter(n -> n > 3).count()
- Sort: nums.stream().sorted().collect(Collectors.toList())