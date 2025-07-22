package designPatern.deckOfCards;

import java.util.*;

public class Deck {
    private final List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
    }
    private void initializeDeck(){

       for(Suit suit: Suit.values()){
        for(Rank rank: Rank.values()){
            cards.add(new Card(suit,rank));
        }
       }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        if(cards.isEmpty()){
            throw new NoSuchElementException("Deck is empty!");
        }
        return cards.remove(cards.size()-1);
    }
    public int remaningCard(){
        return cards.size();
    }
    public void reset(){
        initializeDeck();
        shuffle();
    }
    public List<Card> getCards(){
        return cards;
    }
}
