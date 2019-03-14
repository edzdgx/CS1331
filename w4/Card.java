public class Card {

    // instance variables or fields
    private String rank; // private to the class
    private String suit;

    public Card(String rank, String suit) {
        setRank(rank);
        setSuit(suit);
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK,
             QUEEN, KING, ACE
    }
    public enum Suit {
        DIAMONDS, CLUBS, HEARTS, SPADES
    }

    // statics are shared by the entire class
    // static vars and static methods are parts of class, not instances
    // same thing for all instances of Card
    // final means it can only be set once
    public static final String[] VALID_RANKS =
        {"2", "3", "4", "5", "6", "7", "8", "9",
         "10", "jack", "queen", "king", "ace"};

    public static final String[] VALID_SUITS =
        {"diamonds", "clubs", "hearts", "spades"};

    public String toString() {
        return rank + " of " + suit;
    }

    private void setRank(String rank) {
        this.rank = rank;
    }

    private void setSuit(String suit) {
        this.suit = suit;
    }

    public static void main(String[] args) {
        Card c1 = new Card("Rank.ACE", "Suit.SPADES");
        Card c2 = new Card("Rank.ACE", "Suit.SPADES");
        Card c3 = c1;
        System.out.println("c1 == c2 returns " + (c1 == c2));
        System.out.println("c1.equals(c2) returns " + c1.equals(c2));
        System.out.println("c1 == c3 returns " + (c1 == c3));
        System.out.println("c1.equals(c3) returns " + c1.equals(c3));
    }
}