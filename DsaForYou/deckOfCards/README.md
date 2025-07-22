# Deck of Cards - Java OOP Interview Project

This project demonstrates how to model and manipulate a deck of playing cards using Object-Oriented Programming principles in Java. It covers class design, enums, shuffling, drawing, comparing, and sorting cards. Use this README to quickly explain your approach and code in interviews.

---

## Key Concepts & Structure

- **Card Class**: Represents a single playing card with a suit and rank.
- **Suit & Rank Enums**: Define the possible suits (Hearts, Diamonds, Clubs, Spades) and ranks (Two to Ace).
- **Deck Class**: Manages a collection of cards, supports shuffling, drawing, and resetting.
- **CompareTwoCards**: Utility to compare two cards by rank.
- **CardSorter**: Utility to sort a deck by suit and rank.
- **Main Class**: Demonstrates usage: shuffling, drawing, comparing, and sorting cards.

---

## How It Works

1. **Deck Initialization**

   - Creates 52 unique cards (all suit/rank combinations).
   - Example:
     ```java
     for (Suit suit : Suit.values()) {
         for (Rank rank : Rank.values()) {
             cards.add(new Card(suit, rank));
         }
     }
     ```

2. **Shuffling**

   - Uses `Collections.shuffle()` to randomize the deck.

3. **Drawing a Card**

   - Removes and returns the top card from the deck.
   - Handles empty deck with an exception.

4. **Comparing Two Cards**

   - Compares by rank using ordinal values.
   - Example:
     ```java
     public static Card highestRank(Card c1, Card c2) {
         return c1.getRank().ordinal() >= c2.getRank().ordinal() ? c1 : c2;
     }
     ```

5. **Sorting the Deck**
   - Sorts first by suit, then by rank using comparators.
   - Example:
     ```java
     deck.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
     ```

---

## Sample Interview Questions & Answers

- **How do you model a deck of cards in Java?**
  - Use enums for suit/rank, a Card class for each card, and a Deck class for the collection.
- **How do you shuffle and draw cards?**
  - Shuffle with `Collections.shuffle()`, draw by removing from the deck list.
- **How do you compare two cards?**
  - Compare their rank using ordinal values.
- **How do you sort a deck?**
  - Use a comparator to sort by suit and rank.

---

## Example Output

```
🔀 Shuffled Deck:
KING of HEARTS
TEN of CLUBS
... (all 52 cards in random order)

🃏 Drawing a card...
Drawn Card: QUEEN of SPADES
Remaining cards: 51

🔥 Higher Card between KING and QUEEN: KING of HEARTS

✅ Sorted Deck:
TWO of HEARTS
THREE of HEARTS
... (all 52 cards sorted)
```

---

## Tips for Interview

- Explain your class and enum design clearly.
- Mention how you handle edge cases (empty deck, invalid card).
- Discuss OOP principles: encapsulation, separation of concerns.
- Show how you use Java collections and comparators.

Good luck!
