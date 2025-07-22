package designPatern.deckOfCards;

import java.util.Comparator;
import java.util.List;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit , Rank rank){

        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return rank +" OF "+ suit;
    }
}

//Problem  Compare Two Cards by Rank (Problem 1)
//This method will take two cards and return the one with the higher rank.
// Suit is ignored.

class CompareTwoCards{
    public static Card highestRank(Card card1,Card card2){
        if(card1.getRank().ordinal()>=card2.getRank().ordinal()){
            return card1;
        }
        else return card2;
    }
}

//Sort a Shuffled Deck (Problem 2)
// You are given a shuffled list of cards.
// You need to sort it:

// First by Suit in this order: HEARTS < DIAMONDS < CLUBS < SPADES
// Then by Rank in this order: TWO < THREE < ... < ACE

class CardSorter{
    public static void sortDeck(List<Card> deck){
        deck.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank));
    }
}
