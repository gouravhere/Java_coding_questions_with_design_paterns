Java DSA Quick Reference - Arrays, Strings, Lists
1. Arrays
- Declare: int[] arr = new int[5];
- Length: arr.length
- Access: arr[i]
- Sort: Arrays.sort(arr)
- Fill: Arrays.fill(arr, val)
- Copy: Arrays.copyOf(arr, n)
- Convert to List: Arrays.asList(arr) [Only for Integer[], not int[]]
- 
2.Strings
- Length: s.length()
- Char at: s.charAt(i)
- Substring: s.substring(i, j) [j exclusive]
- Concatenate: s + s2 or s.concat(s2)
- Contains: s.contains("abc")
- Index of: s.indexOf("a")
- Equals: s.equals(s2)
- Split: s.split(" ")
- Replace: s.replace("a", "b")
- Trim: s.trim()
- To Char Array: s.toCharArray()
- To Lower/Upper: s.toLowerCase(), s.toUpperCase()
- Reverse: new StringBuilder(s).reverse().toString()
- 
3. Lists (ArrayList)
- Declare: List<Integer> list = new ArrayList<>();
- Add: list.add(val)
- Add at index: list.add(i, val)
- Get: list.get(i)
- Set: list.set(i, val)
- Remove: list.remove(i)
- Size: list.size()
- Contains: list.contains(val)
- Index of: list.indexOf(val)
- Sort: Collections.sort(list)
- Reverse: Collections.reverse(list)
- Clear: list.clear()
- To Array: list.toArray(new Integer[0])
- 
4. HashMap
- Declare: Map<Character, Integer> map = new HashMap<>();
- Put: map.put(k, v)
  Java DSA Quick Reference - Arrays, Strings, Lists
- Get: map.get(k)
- Contains Key: map.containsKey(k)
- Remove: map.remove(k)
- Iterate: for (Map.Entry<K, V> e : map.entrySet())
- Size: map.size()
- Get or Default: map.getOrDefault(k, 0)
- 
5. HashSet
- Declare: Set<Integer> set = new HashSet<>();
- Add: set.add(val)
- Contains: set.contains(val)
- Remove: set.remove(val)
- Size: set.size()
- Iterate: for (int val : set)