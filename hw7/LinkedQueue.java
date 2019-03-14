import java.util.Iterator;
import java.util.NoSuchElementException;
import javafx.collections.ModifiableObservableListBase;

public class LinkedQueue<E>
    implements SimpleQueue<E>, Iterable<E> {

    private static int size;
    private LinkedQueueNode<E> head;


    /**
      * adds an element to the queue
      * @param e element to be added
      */
    public void enqueue(E e) {
        // if (head == null) {
        //     // create new node with data e and next null
        //     head = new LinkedQueueNode(e, null);
        // } else {
        //     LinkedQueueNode temp = head;
        //     while(temp.getNext() != null) {
        //         temp = temp.getNext();
        //     }
        //     temp.setNext(new LinkedQueueNode(e));
        // }
        size++;
    }

    /**
      * Adds an element to the queue at a specific index
      * Throws an IndexOutOfBoundsException if the index is invalid
      * @param e element to be added
      * @param idx index to add to
      */
    public void doAdd(E e, int idx) {

    }

    /**
      * Removes the least recently added element when queue is non-empty
      * Returns null when queue is empty
      * @return the removed element
      */
    public E dequeue() {
        // if (head != null) {
        //     // do
        //     LinkedQueueNode curr = head;
        //     E temp = curr.getData();
        //     head = curr.getNext();
        //     size--;
        //     return temp;
        // }
        return null;
    }

    /**
      * Removes an element from the queue at a specific index
      * Throws an IndexOutOfBoundsException if the index is invalid
      * @param idx the index to be removed
      * @return the removed element
      */
    public E doRemove(int idx) {
        // if (idx == size - 1) {
        //     return dequeue();
        // } else if (idx >= size) {
        //     LinkedQueueNode curr = head;
        //     // move everything to the left
        //     for (int i = 0; i < idx; i++) {
        //         curr = curr.getNext();
        //     }
        // }
        return curr.getNext()
    }

    /**
      * Returns an element from the queue at a specific index
      * Throws an IndexOutOfBoundsException if the index is invalid
      * @param idx to be returned
      * @return the element at idx
      */
    // public E get(int idx) {
    //     return new E();
    // }

    /**
      * throws an UnsupportedOperationException
    */
    public void doSet() {
        throw new UnsupportedOperationException();
    }

    /**
      * method returns size of queue
      * @return size of queue
      */
    public int size() {
        return size;
    }

    /**
      * method empties queue and sets size to 0
      */
    public void clear() {
        head = null;
    }

    /**
      * method returns true when queue is empty, false otherwise
      * @return empty or not
      */
    public boolean isEmpty() {
        return head == null;
    }

    // // inner class implementing iterator
    // private Iterator<LinkedQueueNode> iterator() {
    //     return new Iterator<>() {
    //         @Override
    //         public boolean hasNext() {
    //             return this.getNext() != null;
    //         }

    //         @Override
    //         public LinkedQueueNode next() {
    //             return this.getNext();
    //         }
    //     };
    // }





}