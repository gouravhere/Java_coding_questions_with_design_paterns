package designPatern.deckOfCards;

public class Main {
    public static void main(String[] args) {
        // Create and shuffle the deck
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println(" Shuffled Deck: ");
        for (Card c : deck.getCards()) {
            System.out.println(c);
        }

        // Draw a card
        System.out.println("\n Drawing a card...");
        Card drawn = deck.drawCard();
        System.out.println("Drawn Card: " + drawn);
        System.out.println("Remaining cards: " + deck.remaningCard());

        // Problem 1: Compare two cards
        Card card1 = new Card(Suit.HEARTS, Rank.KING);
        Card card2 = new Card(Suit.SPADES, Rank.QUEEN);
        Card higher = CompareTwoCards.highestRank(card1, card2);
        System.out.println("\n Higher Card between KING and QUEEN: " + higher);

        // Problem 2: Sort the deck
        CardSorter.sortDeck(deck.getCards());
        System.out.println("\n Sorted Deck:");
        for (Card c : deck.getCards()) {
            System.out.println(c);
        }
    }
}
