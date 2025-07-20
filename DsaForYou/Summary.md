| Category | Important Methods/Properties                                                                      |
|----------|---------------------------------------------------------------------------------------------------|
| Array    | `.length`, `Arrays.sort()`, `Arrays.fill()`                                                       |
| String   | `.length()`, `.charAt()`, `.substring()`, `.equals()`, `.split()`, `.toCharArray()`, `.indexOf()` |
| List     | `.add()`, `.get()`, `.set()`, `.size()`, `.contains()`, `.remove()`                               |
| HashMap  | `.put()`, `.get()`, `.containsKey()`, `.remove()`                                                 |
| HashSet  | `.add()`, `.contains()`, `.remove()`, `.size()`                                                   |


# DsaForYou: Interview Preparation Summary

This README summarizes all the DSA topics and problems you have covered in the `DsaForYou` package, along with a brief note on the approach for each. Use this as a quick revision guide before your interviews!

---

## Arrays

- **BuySellStocks**: Find the maximum profit from a single buy and sell. (Single pass, track min price and max profit)
 
  int min = prices[0], profit = 0;
  for (int p : prices) {
      min = Math.min(min, p);
      profit = Math.max(profit, p - min);
  }
  
- **TwoSum**: Find indices of two numbers that add up to a target. (HashMap for O(n) lookup)
 
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < arr.length; i++) {
      int diff = target - arr[i];
      if (map.containsKey(diff)) return new int[]{map.get(diff), i};
      map.put(arr[i], i);
  }
  
- **MaximumSubarraySum**: Kadane's Algorithm for max subarray sum. (Dynamic programming, O(n))
 
  int max = nums[0], curr = nums[0];
  for (int i = 1; i < nums.length; i++) {
      curr = Math.max(nums[i], curr + nums[i]);
      max = Math.max(max, curr);
  }
  
- **ProductOfArrayExceptSelf**: Return array where each element is the product of all others. (Prefix/suffix product, no division)
 
  int n = nums.length, left = 1, right = 1;
  int[] res = new int[n];
  for (int i = 0; i < n; i++) {
      res[i] = left;
      left *= nums[i];
  }
  for (int i = n - 1; i >= 0; i--) {
      res[i] *= right;
      right *= nums[i];
  }
  
- **RemoveDuplicatesFromArray**: Remove duplicates in-place from sorted array. (Two-pointer technique)
 
  int k = 1;
  for (int i = 1; i < nums.length; i++)
      if (nums[i] != nums[i-1]) nums[k++] = nums[i];
  // k is the new length
  
- **RotateArray**: Rotate array to the right by k steps. (Reverse parts of array)
 
  k %= nums.length;
  reverse(nums, 0, nums.length-1);
  reverse(nums, 0, k-1);
  reverse(nums, k, nums.length-1);
  
- **FindAllNumbersDisappearedInArray**: Find all numbers missing from 1 to n. (Marking indices, O(n) time, O(1) space)
- **SecondLargest**: Find the second largest element. (Single pass, track max and second max)
 
  int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
  for (int n : arr) {
      if (n > max) { second = max; max = n; }
      else if (n > second && n != max) second = n;
  }
  
- **InterviewPersp**: Sum of squares of odd numbers, find pairs with given difference. (Streams, HashSet)
 
  // Sum of squares of odd numbers
  int sum = list.stream().filter(i->i%2!=0).map(i->i*i).reduce(0,Integer::sum);
  // Pairs with given diff
  Set<Integer> set = new HashSet<>(list);
  for (int n : list) if (set.contains(n+diff)) ...
  
- **MissingNumber**: Find the missing number in range [0, n]. (Sum formula or XOR)
 
  int sum = n*(n+1)/2;
  for (int num : nums) sum -= num;
  // or
  int xor = 0;
  for (int i = 0; i <= n; i++) xor ^= i;
  for (int num : nums) xor ^= num;
  
- **FindAllNumbersDisappearedInArray**: Find all numbers missing from 1 to n. (Marking indices, O(n) time, O(1) space)
 
  for (int n : nums) nums[Math.abs(n)-1] = -Math.abs(nums[Math.abs(n)-1]);
  List<Integer> res = new ArrayList<>();
  for (int i = 0; i < nums.length; i++)
      if (nums[i] > 0) res.add(i+1);
  

## Recursion

- **Fibonacci**: Print nth Fibonacci number. (Iterative and recursive approaches)
 
  int fib(int n) {
      if (n <= 1) return n;
      return fib(n-1) + fib(n-2);
  }
  
- **PalindromeNumber**: Check if an integer is a palindrome. (Reverse half the number, compare)
 
  if (x < 0 || (x % 10 == 0 && x != 0)) return false;
  int rev = 0;
  while (x > rev) {
      rev = rev * 10 + x % 10;
      x /= 10;
  }
  return x == rev || x == rev / 10;
  
- **ReverseString**: Reverse a string using two-pointer technique.
 
  char[] arr = s.toCharArray();
  int l = 0, r = arr.length-1;
  while (l < r) {
      char t = arr[l]; arr[l]=arr[r]; arr[r]=t; l++; r--;
  }
  
- **ArrayFlat**: Flatten a 2D array into a 1D list. (Both recursion and streams shown)
 
  void flat(int[][] arr, int row, int col, List<Integer> res) {
      if (row == arr.length) return;
      if (col == arr[row].length) { flat(arr, row+1, 0, res); return; }
      res.add(arr[row][col]);
      flat(arr, row, col+1, res);
  }
  
- **ArrayWithRangeOfNumbers**: Generate array with a range of numbers. (Simple loop)
 
  for (int i = start; i <= end; i++) arr[i-start] = i;
  
- **FactorialTrailingZero**: Count trailing zeros in factorial. (Count factors of 5)
 
  int res = 0;
  for (int i = 5; n/i > 0; i *= 5) res += n/i;
  

## Strings

- **ValidAnagram**: Check if two strings are anagrams. (Count character frequencies)
 
  if (s.length() != t.length()) return false;
  int[] count = new int[26];
  for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i)-'a']++;
      count[t.charAt(i)-'a']--;
  }
  for (int c : count) if (c != 0) return false;
  return true;
  
- **LongestCommonPrefix**: Find longest common prefix among strings. (Horizontal scanning)
 
  String pre = strs[0];
  for (int i = 1; i < strs.length; i++)
      while (!strs[i].startsWith(pre))
          pre = pre.substring(0, pre.length()-1);
  
- **LongestPalindromicSubset**: Find the longest palindromic substring. (Expand around center)

 
  for (int i = 0; i < s.length(); i++) {
      expand(i, i); expand(i, i+1);
  }

  

- **ReverseString / ReverseString2**: Reverse a string (with/without recursion)
 
  // Iterative
  char[] arr = s.toCharArray();
  int l = 0, r = arr.length-1;
  while (l < r) { char t = arr[l]; arr[l]=arr[r]; arr[r]=t; l++; r--; }
  // Recursive
  void rev(char[] arr, int l, int r) {
      if (l >= r) return;
      char t = arr[l]; arr[l]=arr[r]; arr[r]=t;
      rev(arr, l+1, r-1);
  }
  
- **ValidPalindrome**: Check if a string is a palindrome. (Two-pointer)
 
  int l = 0, r = s.length()-1;
  while (l < r) {
      if (s.charAt(l) != s.charAt(r)) return false;
      l++; r--;
  }
  return true;
  
- **HammingDifference**: Calculate Hamming distance between two strings. (Simple loop)
 
  int dist = 0;
  for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) != t.charAt(i)) dist++;
  

## Udemy (Extra Practice)

- **CountCharInString**: Count occurrences of each character.
 
  Map<Character, Integer> map = new HashMap<>();
  for (char c : s.toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);
  
- **ReverseCharInString**: Reverse characters in a string.
 
  char[] arr = s.toCharArray();
  int l = 0, r = arr.length-1;
  while (l < r) {
      char t = arr[l]; arr[l]=arr[r]; arr[r]=t; l++; r--;
  }
  
- **RightAngledTrianglePattern**: Print right-angled triangle pattern. (Nested loops)
 
  for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++)
          System.out.print("*");
      System.out.println();
  }
  
  

**Tip:** Focus on understanding the approach and edge cases for each problem. Practice writing code on paper or a whiteboard for interviews!

Good luck with your preparation! 🚀