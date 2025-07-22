# Deck of Cards Implementation

This package implements a standard 52-card deck with functionality for card comparison, deck shuffling, and card drawing. The implementation follows object-oriented principles and demonstrates good Java practices.

## Components

### 1. Enums

#### `Suit.java`
Represents the four suits in a standard deck of cards:
- HEARTS
- DIAMOND
- CLUBS
- SPADES

#### `Rank.java`
Represents the thirteen ranks in a standard deck of cards:
- TWO through TEN
- JACK
- QUEEN
- KING
- ACE

### 2. `Card.java`
A class representing a single playing card with:
- A `Suit` and `Rank`
- Getters for both properties
- A `toString()` method for display
- Nested utility classes for card comparison and sorting

### 3. `Deck.java`
Manages a collection of cards with operations to:
- Initialize a standard 52-card deck
- Shuffle the deck
- Draw cards
- Check remaining cards
- Reset the deck

### 4. `Main.java`
Demonstrates the functionality with examples of:
- Creating and shuffling a deck
- Drawing cards
- Comparing two cards
- Sorting a deck of cards

## Interview Questions & Answers

### 1. Design Questions

**Q: Why did you choose to use enums for Suit and Rank?**
A: Enums are ideal because they:
- Provide type safety
- Limit possible values to valid suits/ranks
- Allow for easy iteration with `values()`
- Make the code more readable and maintainable

**Q: How would you modify this to support Jokers?**
A: We could:
1. Add JOKER to the `Rank` enum
2. Modify the `Deck` class to optionally include jokers
3. Update the `Card` class to handle joker-specific logic

### 2. Implementation Questions

**Q: How does the shuffling algorithm work in your implementation?**
A: The code uses `Collections.shuffle()` which implements the Fisher-Yates shuffle algorithm. It runs in O(n) time and provides a uniformly random permutation of the list.

**Q: How would you implement a custom sort order for cards?**
A: The `CardSorter` class demonstrates this using `Comparator` chaining. We can easily modify the sort order by adjusting the comparator chain in `CardSorter.sortDeck()`.

### 3. Problem-Solving Questions

**Q: How would you implement a method to check for a straight (5 consecutive cards)?**
```java
public static boolean hasStraight(List<Card> cards) {
    if (cards.size() < 5) return false;
    
    Set<Integer> uniqueRanks = cards.stream()
        .map(card -> card.getRank().ordinal())
        .collect(Collectors.toSet());
    
    List<Integer> sortedRanks = new ArrayList<>(uniqueRanks);
    Collections.sort(sortedRanks);
    
    int consecutive = 1;
    for (int i = 1; i < sortedRanks.size(); i++) {
        if (sortedRanks.get(i) == sortedRanks.get(i-1) + 1) {
            consecutive++;
            if (consecutive == 5) return true;
        } else {
            consecutive = 1;
        }
    }
    return false;
}
```

**Q: How would you modify this to support multiple decks?**
A: We could:
1. Add a `numberOfDecks` parameter to the `Deck` constructor
2. In `initializeDeck()`, multiply the card generation by `numberOfDecks`
3. Update the `reset()` method to maintain the same number of decks

### 4. Testing Questions

**Q: How would you test the shuffle method?**
A: We could:
1. Test that the deck maintains all 52 unique cards after shuffling
2. Test that multiple shuffles produce different orders (though not guaranteed, statistically likely)
3. Test edge cases like shuffling an empty deck or a single-card deck

### 5. Design Pattern Questions

**Q: What design patterns are used in this implementation?**
A: The implementation demonstrates:
1. **Factory Method**: The `Deck` class creates cards
2. **Strategy**: Different comparison strategies can be used for sorting
3. **Immutable Objects**: `Card` objects are immutable
4. **Singleton**: The `Deck` could be made a singleton if only one deck is needed

## Extensibility

The code is designed to be easily extended for:
- Different card games (Poker, Blackjack, etc.)
- Custom card designs or additional properties
- Network play by adding serialization
- Database persistence

## Performance Considerations
- **Time Complexity**:
  - Shuffling: O(n)
  - Drawing a card: O(1)
  - Sorting: O(n log n)
- **Space Complexity**: O(1) for all operations (except sorting, which is O(n) for the temporary array)

## Common Pitfalls
1. **Modification During Iteration**: The implementation avoids concurrent modification exceptions by not modifying the deck while iterating
2. **Null Checks**: Proper null checks should be added in production code
3. **Thread Safety**: The current implementation is not thread-safe; consider synchronization for multi-threaded use
