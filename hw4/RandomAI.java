// good to go
import java.util.Random;

/**
 * RandomAI class extends AI class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class RandomAI extends AI {

    /**
    This is an instance of the Random class. RandomAI will use the power of
    indeterminate, psuedo-randomly generated numbers to determine if the
    weather today will be cloudy with a chance of guacamole
    (i.e. use randomizer to make the 50% chance decisions).
    */
    private Random randomizer = new Random();

    /**
     * Assign both Coordinates instances to their respective instance variables.
     * @param cannonTarget the Coordinates
     * @param secretHQ the Coordinates
     */

    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
    }

    /**
     * This method should override the abstract method found in AI.java.
     * @return true 50% of the time.
     */
    public boolean shouldSwapCannonTarget() {
        return randomizer.nextFloat() >= 0.5;
    }

    /**
     * This method should override the abstract method found in AI.java.
     * @return true 50% of the time.
     */
    public boolean shouldSelfDestruct() {
        return randomizer.nextFloat() >= 0.5;
    }

    // public static void main(String[] args) {
    //     Coordinates x = new Coordinates(10.00, 20.00);
    //     RandomAI a = new RandomAI(x, x);

    //     int count = 0;
    //     for (int i = 0; i < 100; i++) {
    //         if (a.shouldSwapCannonTarget()) {
    //             count++;
    //         }
    //     }

    //     System.out.println(count);
    // }

}