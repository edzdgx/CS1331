// public class ArrayList<T> implements Iterable<T>
import java.util.Iterator;
public class Range implements Iterable<Integer> {

    private class RangeIter implements Iterator<Integer> {
        private int currentIdx;

        public Integer next() {
            return ++currentIdx;
        }

        public boolean hasNext() {
            return currentIdx < 10;
        }
    }

    public RangeIter iterator() {
        return new RangeIter();
    }

    public static void main(String[] args) {
        Range rangeWhile = new Range();
        RangeIter ri = rangeWhile.iterator();
        while (ri.hasNext()) {
            System.out.println(ri.next());
        }

        Range r = new Range();
        for (int i : r) {
            System.out.println(i);
        }
    }
}