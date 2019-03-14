public class Blockbuster {

    public static void main(String[] args) {
        Movie[] cart = {
            new Movie("ACADEMY DINOSAUR", "A Epic Drama", new Drama()),
            new Movie("ALADIN CALENDAR", "A Action-Packed Tale", new Action()),
            new Movie("TERMINATOR", "Governating", new Action()),

        };

        double total = 0.0;
        for (Movie m: cart) {
            MovieType t = m.getType();
            total += t.getPrice();
        }

        System.out.println("total = " + total);

    }
}