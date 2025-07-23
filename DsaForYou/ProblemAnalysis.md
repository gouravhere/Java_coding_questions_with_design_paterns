# DSA Problem Analysis

This document provides a comprehensive analysis of the problems in the DsaForYou package, including time complexity, space complexity, and approaches used.

## Arrays

### 1. Buy and Sell Stocks
- **Problem**: Find the maximum profit from buying and selling a stock once.
- **Approach**: Single pass with minimum price tracking
- **Collections Used**: Primitive array (int[])
- **Time Complexity**: O(n) - Single pass through the array
- **Space Complexity**: O(1) - Constant extra space

### 2. Container With Most Water
- **Problem**: Find two lines that together with the x-axis forms a container that would contain the most water.
- **Approach**: Two pointers
- **Collections Used**: Primitive array (int[])
- **Time Complexity**: O(n) - Single pass with two pointers
- **Space Complexity**: O(1) - Constant extra space

### 3. Remove Duplicates from Sorted Array
- **Problem**: Remove duplicates in-place from a sorted array and return the number of unique elements.
- **Approach**: Two pointers
- **Collections Used**: Primitive array (int[])
- **Time Complexity**: O(n) - Single pass through the array
- **Space Complexity**: O(1) - In-place modification

## Recursion

### 1. Fibonacci
- **Problem**: Calculate the nth Fibonacci number
- **Approach**: Iterative with constant space
- **Collections Used**: Primitive integers (no collections)
- **Time Complexity**: O(n) - Iterative approach
- **Space Complexity**: O(1) - Only a few variables used

### 2. Array Flattening
- **Problem**: Flatten a 2D array into 1D
- **Approach 1 (Streams)**: 
  - **Collections Used**: 2D array (int[][]), ArrayList<Integer>
  - Time: O(n*m) where n is number of rows, m is average columns
  - Space: O(n*m) for the new list
- **Approach 2 (Recursion)**:
  - **Collections Used**: 2D array (int[][]), ArrayList<Integer>
  - Time: O(n*m)
  - Space: O(n*m) + recursion stack space

### 3. Palindrome Number
- **Problem**: Check if a number is a palindrome
- **Approach**: Reverse half of the number
- **Time Complexity**: O(log n) - We're dividing the number by 10 each time
- **Space Complexity**: O(1) - Constant extra space

## Strings

### 1. Valid Palindrome
- **Problem**: Check if a string is a palindrome, considering only alphanumeric characters and ignoring cases
- **Approach**: Two pointers with character validation
- **Collections Used**: String, char array (String.toCharArray())
- **Time Complexity**: O(n) - Single pass through the string
- **Space Complexity**: O(1) - No extra space used (in-place processing)

### 2. Reverse String II
- **Problem**: Reverse the first k characters for every 2k characters
- **Approach**: Iterate with 2k steps and reverse k characters
- **Collections Used**: String, char array (String.toCharArray())
- **Time Complexity**: O(n) - Each character is processed exactly once
- **Space Complexity**: O(n) - For the character array

### 3. Valid Anagram
- **Problem**: Check if two strings are anagrams
- **Approach**: Character frequency counting
- **Collections Used**: String, char array (String.toCharArray())
- **Time Complexity**: O(n) - Two passes through each string
- **Space Complexity**: O(1) - Fixed size frequency array (26 for English letters)

## Deck of Cards

### 1. Deck Implementation
- **Operations**:
  - shuffle(): O(n) time using Fisher-Yates
  - drawCard(): O(1) time
  - remaningCard(): O(1) time
- **Collections Used**: ArrayList<Card>, Enum (Suit, Rank)
- **Space Complexity**: O(52) = O(1) - Fixed size deck

### 2. Card Comparison
- **Approach**: Compare card ranks with enum ordinals
- **Collections Used**: Enum (Rank, Suit), Card class
- **Time Complexity**: O(1)
- **Space Complexity**: O(1)

## Common Patterns Used

1. **Two Pointers**: Used in array and string problems for efficient traversal
2. **Sliding Window**: For subarray/substring problems
3. **In-place Modification**: To achieve O(1) space complexity
4. **Iterative vs Recursive**: Trade-offs between stack space and readability
5. **Frequency Counting**: Using arrays or HashMaps for character/word counting

## Performance Considerations

1. **Array vs LinkedList**: Random access vs insertions/deletions
2. **Time-Space Tradeoff**: Sometimes using extra space can improve time complexity
3. **Edge Cases**: Always consider empty inputs, single element, duplicates, etc.
4. **Input Constraints**: The optimal solution might depend on input size and constraints

## Collections Used

1. **ArrayList**: For dynamic array operations
2. **Arrays**: For fixed-size collections
3. **Character Arrays**: For in-place string manipulation
4. **Enums**: For fixed set of constants (like card ranks and suits)

## Best Practices

1. Always validate input parameters
2. Consider edge cases first
3. Optimize for the most constrained resource (time or space)
4. Use meaningful variable names
5. Add comments for complex logic
6. Write test cases for different scenarios
