import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
/**
 * Account class with multiple functions
 *
 * @author xzhou309
 * @version 1.0
 */
public class Account {
    // fields
    // past Transactions
    private List<Transaction> pastTransactions;

    // constructors
    /**
    *
    * takes in one parameter that should be assigned to pastTransactions
    * @param pastTransactions represents pastTransactions
    */
    public Account(List<Transaction> pastTransactions) {
        this.pastTransactions = pastTransactions;
    }

    // methods
    /**
     * getter method for the pastTransactions field
     * @return the current value of pastTransactions
     */
    public List<Transaction> getPastTransactions() {
        return pastTransactions;
    }

    /**
     * return the nth transaction from pastTransactions
     * @param n the number of transaction wanted
     * @return the nth transaction from pastTransactions
     */
    public Transaction getTransaction(int n) {
        return pastTransactions.get(n);
    }

    /**
     * Returns a list of Transactions from pastTransactions filtered by the
     * predicate. If the predicate returns true when a Transaction is passed in,
     * keep it. Otherwise filter it out of the returned list. Must not modify
     * pastTransactions field.
     * @param predicate to filter the list
     * @return a filtered list of Transactions from pastTransactions
     */
    public List<Transaction> findTransactionsByPredicate(
                      Predicate<Transaction> predicate) {
        return getPastTransactions()
            .stream()
            .filter(predicate)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private class Inner implements Predicate<Transaction> {
        private double amount;

        Inner(double amount) {
            this.amount = amount;
        }

        @Override
        public boolean test(Transaction t) {
            return t.getAmount() == amount;
        }
    }
    /**
      * returns a list of Transactions with an amount field that equals the
      * parameter amount. Must not modify pastTransactions field. Must call
      * findTransactionsByPredicate with an instance of an inner class.
      * @param amount amount of transactions
      * @return list of Transaction with amount = amount parameter
      */
    public List<Transaction> getTransactionsByAmount(double amount) {
        Inner in = new Inner(amount);
        return findTransactionsByPredicate(in);
    }

    /**
      * returns a list of Transactions that are withdrawals. Must not modify
      * pastTransactions field. Must call findTransactionsByPredicate with
      * an instance created with an anonymous inner class.
      * @return all withdrawls
      */
    public List<Transaction> getWithdrawals() {
        Predicate<Transaction> p = new Predicate<Transaction>() {
            public boolean test(Transaction t) {
                return t.getType().equals(TransactionType.WITHDRAWAL);
            }
        };
        return findTransactionsByPredicate(p);
    }

    /**
      * returns a list of Transactions that are deposits. Must not modify
      * pastTransactions field. Must call findTransactionsByPredicate with
      * an instance created with a lambda expression.
      * @return all deposits
      */
    public List<Transaction> getDeposits() {
        Predicate<Transaction> p = (Transaction t) ->
            t.getType().equals(TransactionType.DEPOSIT);
        return findTransactionsByPredicate(p);
    }

    /**
      * returns a list of Transactions with comments that are longer than
      * length. Must not modify pastTransactions field. Must call
      * findTransactionsByPredicate but you can use whatever technique
      * to create the Predicate that you like.
      * @param length comments longer than
      * @return length of comment greater than parameter
      */
    public List<Transaction> getTransactionsWithCommentLongerThan(int length) {
        Predicate<Transaction> p = (Transaction t) ->
            t.getComment().isPresent()
            && t.getComment().get().length() > length;
        return findTransactionsByPredicate(p);
    }

    /**
      * returns a list of Transactions with a comment that is not empty.
      * Must not modify pastTransactions field. Must call
      * findTransactionsByPredicate with a lambda expression or
      * method reference.
      * @return all transactions with non-null comments
      */
    public List<Transaction> getTransactionsWithComment() {
        Predicate<Transaction> p = (Transaction t) ->
            t.getComment().isPresent();
        return findTransactionsByPredicate(p);
    }


}