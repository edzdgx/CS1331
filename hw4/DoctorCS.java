/* It is not good style because if new extended types are added later,
   new type could change the behavior. instanceof() can be avoided by creating
   a enum type containing all subclasses value, then a getType() method to
   return the corresponding subclass names.
*/
/**
 * Coordinates class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class DoctorCS {
    /** This is the AI object upon which you can invoke the various methods
      * to save the day. Do not create a setter method for this field.
      */
    private AI ai;

    /**
      * This contains the Doctor CS’s hidden identity. This should not be
      * publicly accessible, and it should be immutable.
      * (no getter, no setter)
      */
    private final String secretIdentity;

    /**
      * This is an integer representation of the Doctor CS’s Justice League of
      * America ID. It should be publicly accessible, but like his
      * secret identity, this should also be immutable.
      */
    private final int jlaid;

    /**
      * Do not write a getter for this variable. This is a boolean that
      * represents whether the threat of Dr. Chipotle has been alleviated.
      * This instance variable should not be changed outside
      * of the DoctorCS class. (Does this need a setter? NO)
      */
    private boolean safe;

    /**
     * getter method for the DoctorCS field
     * @return the current value of ai
     */
    public AI getAI() {
        return ai;
    }

    /**
     * getter method for the DoctorCS field
     * @return the current value of jlaid
     */
    public int getJlaid() {
        return jlaid;
    }

    /**
      * This constructor takes in an AI object and assigns it to ai, a String
      * that is assigned to secretIdentity, and an int and stores it in jlaid.
      * It should also initialize safe to be false.
      * @param ai instance of AI
      * @param secretIdentity String of identity
      * @param jlaid the id
      */
    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;
    }

    /**
      * This method functions as a conditional setter for the safe instance
      * variable. If ai is an instance of a RogueAI, then continuously invoke
      * the lowerFirewall() method while firewallProtection is greater than 0.
      * After that is done or if ai is simply a RandomAI call swapCannonTarget()
      * on the ai and pass in the ai’s secretHQ field.
      * The return value should be assigned to safe.
      */
    void saveTheDay() {
        RogueAI a = (RogueAI) (this.ai);
        if (ai instanceof RogueAI) {
            while ((a).getFirewallProtection() > 0) {
                (a).lowerFirewall();
            }
            safe = (a).swapCannonTarget((a).getSecretHQ());
        } else {
            safe = (a).swapCannonTarget((a).getSecretHQ());
        }
    }

    /**
      * This method will return a different String depending on the
      * value of safe and the value of destructed in the instance ai.
      * If safe, then return the following: “Doctor CS has saved the day!”
      * If NOT safe and the value of destructed in the ai instance is true,
      * then return the following: “Dr. Chipotle has succeeded in his plan…”
      * Otherwise, return the following: “Georgia Tech is still in danger!”
      * @return String representation of current status
      */
    public String getStatus() {
        if (safe) {
            return "Doctor CS has saved the day!";
        } else if (!safe && ai.getDestructed()) {
            return "Dr. Chipotle has succeeded in his plan…";
        } else {
            return "Georgia Tech is still in danger!";
        }
    }

    /**
      * This returns the String representation of Doctor CS’s information in the
      * following format: "(secretIdentity) aka Doctor CS with JLAID: (jlaid)"
      * "Robert Paulson aka Doctor CS with JLAID: 12345678"
      * @return String representation of DoctorCS
      */
    public String toString() {
        return String.format("%s aka Doctor CS with JLAID: %s",
                             secretIdentity, jlaid);
    }









}