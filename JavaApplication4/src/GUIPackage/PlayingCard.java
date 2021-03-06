package GUIPackage;

import java.util.*;
import java.lang.*;

/** class Card : for creating playing card objects
 *  it is immutable class.
 *  Do not modify this class!
 */

class Card {

    /* constant suits and ranks */
    static final String[] Suit = {"Spades","Hearts","Clubs","Diamonds"};
    static final String[] Rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    /* Data field of a card: rank and suit */
    private String cardRank;
    private String cardSuit;

    /* Constructor to create a card */
    public Card(String arank, String asuit) {
        cardRank = arank;
        cardSuit = asuit;
    }

    /* Accessor and toString */
    public String getRank() { return cardRank; }
    public String getSuit() { return cardSuit; }
    public String toString() { return cardRank + " " + cardSuit; }

    /* Quick way to tests here */
//    public static void main(String args[])
//    {
//	String a = Rank[2];
//	String b = Suit[3];
//	Card c = new Card(a,b);
//	System.out.println(c);
//    }
}


/** class Deck represents a deck of 52 playing cards
 */
/*public*/ class Deck {
    /* size = 52 cards */
    private final int deckSize=52;

    /* this is used to keep track of original 52 cards */
    private ArrayList<Card> originalDeck;

    /* this starts with 52 cards deck (from original deck)  */
    /* it keeps track of remaining cards to deal            */
    /* see reset(): it resets dealDeck to a full deck       */
    private ArrayList<Card> dealDeck;


    /**
     * Constructor: Creates 52 playing cards in originalDeck and
     * 		    copy them to dealDeck
     * note: use ArrayList for both originalDeck & dealDeck
     *
     */
    public Deck()
    {
        int i;
        Card tmpcard;
	// implement this method!
        originalDeck= new ArrayList<Card>();
        for(i=0; i<4; i++)//suite
        {
            for(int n=0; n<13; n++)
            {
                tmpcard= new Card(Card.Rank[n], Card.Suit[i]);
                originalDeck.add(tmpcard);
            }
        }

        dealDeck= (ArrayList)originalDeck.clone(); //shallow coppy

    }

    /**
     * Task: Shuffles cards in deal deck.
     * Hint: Look at java.util.Collections
     */
    public void shuffle()
    {
	// implement this method!
        java.util.Collections.shuffle(dealDeck);

    }

    /**
     * Task: Deals cards from the deal deck.
     *
     * @param numberCards number of cards to deal
     * @return a list containing cards that were dealt
     * @throw runtime exception if numberCard > number of remaining cards
     *
     * Note: You need to create ArrayList to stored dealt cards
     *       and should removed dealt cards from dealDeck
     */
    public ArrayList<Card> deal(int numberCards)
    {
	// implement this method!
        ArrayList<Card> tmplist= new ArrayList<Card>();
        //Integer lastIndex= new Integer(null);
        int lastIndex=0; int i;

        for(i=0; i < numberCards; i++)
        {
            lastIndex= dealDeck.size()-1; //gets last index of dealDeck
            tmplist.add(dealDeck.get(lastIndex));//assigns last card to tmplist
            dealDeck.remove(lastIndex); //removes last card from dealdeck
        }
        return tmplist;
        //return null;
    }
    /**
     * Task: Resets deal deck by getting all 52 cards from the original deck.
     */
    public void reset()
    {
        dealDeck= (ArrayList)originalDeck.clone(); //shallow coppy
    }


    /**
     * Task: Returns a string representing cards in the deal deck
     */
    @Override
    public String toString()
    {
	return ""+dealDeck;
    }

    /* Quick test                */
    /* Do not modify these tests */
//    public static void main(String args[]) {
//        int numHands = 3;
//        int cardsPerHand = 15;
//        Deck deck  = new Deck();
//
//	for (int j=0; j < 2; j++)
//	{
//        	System.out.println("===========================");
//		System.out.println("Before shuffle:"+deck);
//        	System.out.println("===========================");
//
//        	for (int i=0; i < numHands; i++)
//	 	{
//	    		deck.shuffle();
//            		System.out.println("Shuffle:"+deck);
//            		System.out.println("\n\nHand "+i+":"+deck.deal(cardsPerHand));
//            		System.out.println("\n\nRemain:"+deck);
//            		System.out.println("===========================");
//		}
//		deck.reset();
//	}
//
//	try {
//		deck.deal(55);
//	}
// 	catch (Exception e)
//	{
//		 System.out.println("Exception:"+e.getMessage());
//	}
//        System.out.println("===========================");
//    }

}
