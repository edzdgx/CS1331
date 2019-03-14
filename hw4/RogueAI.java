// good to go
/**
 * RogueAI class extends AI class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class RogueAI extends AI {
    /**
      * This is an int that represents security level of the firewall.
      * Doctor CS must first lower it to 0 in order to access the secret info.
      */
    private int firewallProtection;

    /**
      * This is an int that represents the current alert level of the computer.
      * It will raise every single time Doctor CS tries to either lower the
      * firewall or swap the guac cannon’s target. More on that later.
      */
    private int alertLevel;

    /**
      * This is a constant int variable that represents the alert level
      * at which the computer self destructs. If alertLevel goes above
      * this threshold, it will be impossible for Doctor CS to save the day.
      */
    private final int maxAlert;

    /**
     * getter method for the RogueAI field
     * @return the current value of firewallProtection
     */
    public int getFirewallProtection() {
        return firewallProtection;
    }

    /**
     * getter method for the RogueAI field
     * @return the current value of alertLevel
     */
    public int getAlertLevel() {
        return alertLevel;
    }

    /**
     * getter method for the RogueAI field
     * @return the current value of maxAlert
     */
    public int getMaxAlert() {
        return maxAlert;
    }

    /**
     * This constructor takes in three ints and two Coordinates objects
     * and assigns them to their corresponding instance fields.
     * @param firewallProtection int for firewall
     * @param alertLevel int for alert level
     * @param maxAlert int for maximum
     * @param cannonTarget coordinates of target
     * @param secretHQ coordinates of HQ
     *
     */
    public RogueAI(int firewallProtection, int alertLevel, int maxAlert,
                   Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }

    /**
      * This constructor takes in two ints and two Coordinates objects
      * and assigns them to their corresponding instance fields.
      * It also sets alertLevel to 0.
      * @param firewallProtection int for firewall
      * @param maxAlert int for maximum
      * @param cannonTarget coordinates of target
      * @param secretHQ coordinates of HQ
      *
      */
    public RogueAI(int firewallProtection, int maxAlert,
                   Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 0, maxAlert, cannonTarget, secretHQ);
    }

    /**
      * This constructor takes in one int and two Coordinates objects and
      * assigns them to their corresponding instance fields.
      * It also sets alertLevel to 0 and maxAlert to 10.
      * @param firewallProtection int for firewall
      * @param cannonTarget coordinates of target
      * @param secretHQ coordinates of HQ
      */
    public RogueAI(int firewallProtection, Coordinates cannonTarget,
                   Coordinates secretHQ) {
        this(firewallProtection, 0, 10, cannonTarget, secretHQ);
    }

    /**
      * This method should decrement firewallProtection by 2,
      * and increment alertLevel by 1 when invoked.
      */
    public void lowerFirewall() {
        firewallProtection -= 2;
        alertLevel++;
    }
    /**
      * This method should override the abstract method found in AI.java.
      * @return boolean whether firewallProtection is 0 or not
      */
    public boolean shouldSwapCannonTarget() {
        return firewallProtection <= 0;
    }
    /**
      * This method should override the abstract method found in AI.java.
      * @return boolean whether or not alertlevel exceeds maxAlert
      */
    public boolean shouldSelfDestruct() {
        return alertLevel >= maxAlert;
    }

    /**
      * toString method to visualize RogueAI
      * @return a String representation of RogueAI instance
      */

    public String toString() {
        return "Dr. Chipotle's guacamole cannon is currently pointed at "
               + getCannonTarget().toString() + ", and is at alert level "
               + alertLevel + " with firewall protection "
               + firewallProtection + ".";
    }

    // public static void main(String[] args) {
    //     Coordinates x = new Coordinates(50.0, 25.5);
    //     RogueAI ra = new RogueAI(1, 2, 3, x, x);
    //     System.out.println(ra);
    // }


}