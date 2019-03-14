/**
 * VendingItem enum type with functionalities
 *
 * @author xzhou309
 * @version 1.0
 */
public enum VendingItem {
    //Item              Price
    Lays                (1.50),
    Doritos             (1.50),
    Coke                (2.50),
    Ramblin_Reck_Toy    (180.75),
    Rubiks_Cube         (30.00),
    Rat_Cap             (15.00),
    FASET_Lanyard       (10.00),
    Graphing_Calculator (120.00),
    UGA_Diploma         (0.10),
    Pie                 (3.14),
    Clicker             (55.55),
    Cheetos             (1.25),
    Sprite              (2.50),
    Red_Bull            (4.75),
    Ramen               (3.15),
    Cold_Pizza          (0.99);

    //This field is the price of an item, and should be set in the constructor.
    private final double price;

    /*This is the constructor for the enum type, and it takes the price as its
    single parameter. Review the links and details in the Background section
    if this confuses you.*/
    /**
     * @param price input to set the price equal to
     * @return a String representation of the VendingMachine for use
     *         in your simulation
     */
    VendingItem(double price) {
        this.price = price;
    }

    /**
     * getter method for the price
     * @return the value of price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * toString function to print out VendingItem object
     * @return a String representation of the VendingItem
     */
    @Override // override the original toString in enum
    public String toString() {
        return super.toString() + String.format(": %.2f", this.getPrice());
    }
    // /**
    //  * Runner
    //  * @param args Program arguments
    //  */
    // public static void main(String[] args) {


    //     Random rand = new Random();
    //     System.out.println(VendingItem.Ramen);
    //     // generates [0 1 2 3 4] randomly
    //     //int n0 = rand.nextInt(5);
    //     // formula for generating random integers between a and b, INCLUSIVE
    //     //int n1 = rand.nextInt(b - a + 1) + a;

    // }
}