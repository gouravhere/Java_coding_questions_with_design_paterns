package DsaForYou.deckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

//Created enums - step 1
enum Suit {
    HEARTS, DIAMOND, CLUBS, SPADES;
}

enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

}

// Created Card class - Step 2
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + "of" + suit;
    }
}

// Step 3 - Create Deck class

class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        cards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new NoSuchElementException("Deck is empty!");
        }
        return cards.remove(cards.size() - 1);
    }

    public int remaningCard() {
        return cards.size();
    }

    public void reset() {
        initializeDeck();
        shuffle();
    }

    public List<Card> getCards() {
        return cards;
    }
}

// Step 4: Compare Two Cards by Rank (Problem 1)
// This method will take two cards and return the one with the higher rank.
// Suit is ignored.

class CompareTwoCards {
    public static Card highestRank(Card card1, Card card2) {
        if (card1.getRank().ordinal() >= card2.getRank().ordinal()) {
            return card1;
        } else
            return card2;
    }
}
// Step 5: Sort a Shuffled Deck (Problem 2)
// You are given a shuffled list of cards.
// You need to sort it:

// First by Suit in this order: HEARTS < DIAMONDS < CLUBS < SPADES
// Then by Rank in this order: TWO < THREE < ... < ACE

class CardSorter {
    public static void SortDeck(List<Card> deck) {
        deck.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
    }
}
