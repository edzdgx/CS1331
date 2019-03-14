import java.util.Random;

/**
 * VendingMachine class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class VendingMachine {
    // initialized to 0 and keep track of all machines
    private static double totalSales = 0;
    private VendingItem[][][] shelf;
    private int luckyChance;
    private Random rand = new Random();

    /**
     * Single no-arg constructor for VendingMachines
     * Creates a VendingMachine with 6 rows, 3 columns, and 5 positions
     * per location, totalSales of 0.0, luckyChance of 0, and called restock()
     */
    public VendingMachine() {
        shelf = new VendingItem[6][3][5];
        luckyChance = 0;
        restock();
    }

    /**
     * dispense an item from the vending machine.
     * 1. row/col index out of bounds (check)
     * 2. shelf[row][col][0] == null
     * 3. free
     * 4. col with 2-digits
     * @param code the user input string
     * @return the purchased item
     * @throws Exception if index out of bounds
     */
    public VendingItem vend(String code) {
        if (code.length() != 2
            || code.charAt(0) != (code.toUpperCase().charAt(0))) {
            System.out.println("Invalid User Input!!!");
            return null;
        }
        // getting row and col value by intepreting @param code
        int row, col;
        try {
            row = code.toLowerCase().charAt(0) - 'a';
            col = Integer.parseInt(String.valueOf(code.charAt(1))) - 1;
        } catch (Exception d) {
            System.out.println("Invalid User Input!!!");
            return null;
        }
        //System.out.println(row);
        //System.out.println(col);
        VendingItem purchased;
        try {
            purchased = shelf[row][col][0];
            if (!free()) {
                totalSales += purchased.getPrice();
            }
            System.out.println(totalSales);
        } catch (Exception e) {
            System.out.println("IndexOutOfBounds!!!!");
            return null;
        }

        // move item from a spot forward
        for (int k = 0; k < (shelf[row][col].length - 1); k++) {
            shelf[row][col][k] = shelf[row][col][k + 1];
        }
        // set last item to null
        shelf[row][col][shelf[row][col].length - 1] = null;

        return purchased;
    }


    /**
     * determine if the current user should recieve their item for free
     * meanwhile updating luckyChance accordingly
     * @reveturn boolean that determines free or not
     */
    private boolean free() {
        int randint = rand.nextInt(101);
        // System.out.print(randint);
        // System.out.print("   ");
        // System.out.println(luckyChance);
        if (randint <= luckyChance) {
            luckyChance = 0;
            return true;
        } else {
            luckyChance++;
            return false;
        }
    }

    /**
     * Fill each spot in the vending machine with a randomly chosen item
     */
    public void restock() {
        int itemlength = VendingItem.values().length;
        int randint;

        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                //System.out.println(randint);
                //System.out.println(VendingItem.values()[randint]);
                for (int k = 0; k < shelf[i][j].length; k++) {
                    randint = rand.nextInt(itemlength);
                    shelf[i][j][k] = VendingItem.values()[randint];
                }
            }
        }
    }

    /**
     * getter method for the totalSales field
     * @return the current value of luckyChance
     */
    public static double getTotalSales() {
        return totalSales;
    }

    /**
     * Counting total number of items in a machine
     * @return the total number of VendingItems in the vending machine
     */
    public int getNumberOfItems() {
        int num = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    /**
     * Counting total value of items in a machine
     * @return the combined total value of all the VendingItems in a VM
     */
    public double getTotalValue() {
        double num = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        num += shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return num;
    }

    /**
     * for debugging purposes
     * @return the current value of luckyChance
     */
    public int getLuckyChance() {
        return this.luckyChance;
    }


    /**
     * toString function for VendingMachine visualization
     * @return a String representation of the VendingMachine for use
     *         in your simulation
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }

    // /**
    //  * Runner
    //  * @param args Program arguments
    //  */
    // public static void main(String[] args) {
    //     VendingMachine vm = new VendingMachine();
    //     System.out.println(vm);

    //     VendingItem p0 = vm.vend("A3");
    //     System.out.println(vm.getTotalValue());
    //     VendingItem p1 = vm.vend("A3");
    //     System.out.println(vm.getTotalValue());
    //     VendingItem p2 = vm.vend("A3");
    //     System.out.println(vm);
    //     VendingItem p3 = vm.vend("A3");
    //     System.out.println(vm);
    //     VendingItem p4 = vm.vend("A3");
    //     System.out.println(vm.getTotalValue());
    //     VendingItem p5 = vm.vend("A3");
    //     System.out.println(vm.getTotalValue());
    //     VendingItem p6 = vm.vend("A3");
    //     System.out.println(vm.getTotalValue());

    //     // for (int i = 0; i < 100; i++) {
    //     //     System.out.println(vm.free());

    //     // }
    // }
}



