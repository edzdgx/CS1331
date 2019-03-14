import java.util.Optional;
/**
 * Transaction class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class Transaction {
    // fields
    private TransactionType type;
    private double amount;
    private Optional<String> comment;

    // constructors
    /**
    *
    * takes in two parameters that should be assigned to
    * type and amount respectively.
    * set the comment to Optional.empty()
    * @param type represents type
    * @param amount represents amount
    */
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.comment = Optional.empty();
    }

    /**
    *
    * takes in three parameters that should be assigned to
    * type, ammount, and initialize comment respectively.
    * @param type represents type
    * @param amount represents amount
    * @param s represents the value of comment
    */
    public Transaction(TransactionType type, double amount, String s) {
        this.type = type;
        this.amount = amount;
        this.comment = Optional.ofNullable(s);
    }

    // methods
    /**
     * getter method for the type field
     * @return the current value of type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * getter method for the amount field
     * @return the current value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * getter method for the comment field
     * @return the current value of comment
     */
    public Optional<String> getComment() {
        return comment;
    }

    /**
     * checking if comment exists
     * @return true if comment is not empty, false otherwise.
     */
    public boolean hasComment() {
        return comment.isPresent();
    }

    // // debugging
    // public String toString() {
    //     return String.format("%s, %.2f, %s",
    //             this.getType(), this.getAmount(), this.getComment());
    // }


}