/**
 * @author xzhou309
 * @version 1.0.0
 * @param <E> is the generic type to be later defined
 * defines the List interface to be used in HW5
*/
public class MyList<E> implements List<E> {
    /**
     * elements The backing array of generic type E
     */
    private E[] elements;

    /**
     * An int that represents the count of all non-null elements in the array
     */
    private int size;

    /**
     * No arg constructor that sets the instance fields.
     */
    @SuppressWarnings("unchecked")
    public MyList() {
        this.size = 0;
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * one-argument constructor
     * @param capacity the size of MyList
     */
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.size = 0;
        this.elements = (E[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("argument cannot be null!");
        } else {
            int idx = 0;
            while (idx < elements.length) {
                // System.out.println("****before changing: " + elements[idx]);
                if (elements[idx] == null) {
                    elements[idx] = e;
                    // System.out.println("after changing: " + elements[idx]);
                    size++;
                    // System.out.println("size = " + size);
                    return;
                }

                idx++;
            }

            // if got out of the for loop, meaning no null in elements
            E[] temp = (E[]) new Object[2 * elements.length];
            for (int i = 0; i < size; i++) {
                temp[i] = elements[i];
            }
            temp[size] = e;

            size++;
            elements = temp;
            // System.out.println("capacity: " + elements.length);
            return;
        }
    }

    @Override
    public E get(int index) {
        if (index >= size || size == 0) {
            String s = String.format("Index %d out of bounds for "
                                     + "list of size %d", index, size);
            throw new IndexOutOfBoundsException(s);
        } else {
            return this.elements[index];
        }
    }

    @Override
    public void replace(E e, E replaceWith) {
        if (e == null || replaceWith == null) {
            throw new IllegalArgumentException("input cannot be null!!!");
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == e) {
                    elements[i] = replaceWith;
                }
            }
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public int remove(E e) {
        // count the instances of e in elements
        if (e == null) {
            throw new IllegalArgumentException("input cannot be null!!!");
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                elements[i] = null;
                count++;
            }
        }


        // new array to store + temp idx
        E[] temp = (E[]) new Object[elements.length];
        int idx = 0;

        // another for loop to move all null to the right
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                temp[idx] = elements[i];
                idx++;
            }
        }

        elements = temp;
        // new size
        size -= count;
        // System.out.println("removed " + count);
        return count;
    }

    @Override
    public int contains(E e) {
        if (e == null) {
            throw new IllegalArgumentException("input cannot be null!!!");
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                count++;
            }
        }
        // System.out.println("contains " + count);
        return count;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        for (E e : elements) {
            e = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E[] toArray(E[] e) {
        if (e == null) {
            throw new IllegalArgumentException("input cannot be null!!!");
        }
        if (e.length <= size) {
            for (int i = 0; i < e.length; i++) {
                e[i] = elements[i];
            }
            return e;
        } else {
            for (int i = 0; i < e.length; i++) {
                if (i < size) {
                    e[i] = elements[i];
                } else {
                    e[i] = null;
                }
            }
            return e;
        }
    }




}