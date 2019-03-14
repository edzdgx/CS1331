/**
 * AI abstract class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public abstract class AI {

    // A boolean that represents whether the AI has self-destructed or not.
    // Default value is false.
    private boolean destructed = false;
    // An instance of Coordinates that represents the location at which
    // Dr. Chipotle’s guacamole cannon is aimed.
    private Coordinates cannonTarget;
    // An instance of Coordinates that represents the location of
    // Dr. Chipotle’s secret headquarters.
    private Coordinates secretHQ;


    /**
     * Creates an AI with all required parameters.
     *
     * @param cannonTarget the Coordinates of target
     * @param secretHQ the Coordinates of HQ
     */
    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }

    /**
     * getter method for the AI field
     * @return the current value of cannonTarget
     */
    public Coordinates getCannonTarget() {
        return cannonTarget;
    }

    /**
     * getter method for the AI field
     * @return the current value of secretHQ
     */
    public Coordinates getSecretHQ() {
        return secretHQ;
    }

    /**
     * getter method for the AI field
     * @return the current value of destructed
     */
    public boolean getDestructed() {
        return destructed;
    }

    /**
      * function to determine whether swap or not
      * @param newCoords coordinate
      * @return whether swap or not
      */
    public boolean swapCannonTarget(Coordinates newCoords) {
        if (!destructed && !newCoords.equals(cannonTarget)) {
            if (shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            } else if (shouldSelfDestruct()) {
                selfDestruct();
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
      * This method functions as a setter for the destructed instance variable,
      * but it will only set destructed to true whenever invoked.
      */
    public void selfDestruct() {
        destructed = true;
    }

    /**
      * This method will be implemented in the subclasses of AI. Do not make
      * @return boolean whether should swap or not
      */
    public abstract boolean shouldSwapCannonTarget();

    /**
      * This method will be implemented in the subclasses of AI.
      * @return boolean whether should self destruct or not
      */
    public abstract boolean shouldSelfDestruct();

    /**
      * This method returns a String representation of the
      * AI object which should have the following structure:
      * "Dr. Chipotle's guacamole cannon is currently pointed
      * at latitude: 13.31, longitude: 13.01."
      * @return String to visualize Coordinates
      */
    public String toString() {
        return "Dr. Chipotle’s guacamole cannon is currently pointed at "
                + cannonTarget;
    }


}