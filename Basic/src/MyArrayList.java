import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import utils.*;

public class MyArrayList<E> {
    // The underlying array that actually stores data
    private E[] data;
    // Tracks the current number of elements
    private int size;
    // Default initial capacity
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    // Add
    public void addLast(E e) {
        int cap = data.length;
        // Check if the array capacity is sufficient
        if (size == cap) {
            resize(2 * cap);
        }
        // Insert the element at the end
        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        // Check for index out of bounds
        checkPositionIndex(index);

        int cap = data.length;
        // Check if the array capacity is sufficient
        if (size == cap) {
            resize(2 * cap);
        }

        // Shift data from data[index..] to data[index+1..]
        // Make space for the new element
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // Insert the new element
        data[index] = e;

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // Remove
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int cap = data.length;
        // Can shrink to save space
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[size - 1];
        // Remove the last element
        // Must set the last element to null to avoid memory leaks
        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    public E remove(int index) {
        // Check for index out of bounds
        checkElementIndex(index);

        int cap = data.length;
        // Can shrink to save space
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E deletedVal = data[index];

        // Shift data from data[index+1..] to data[index..]
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        data[size - 1] = null;
        size--;

        return deletedVal;
    }

    public E removeFirst() {
        return remove(0);
    }

    // Get
    public E get(int index) {
        // Check for index out of bounds
        checkElementIndex(index);

        return data[index];
    }

    // Set
    public E set(int index, E element) {
        // Check for index out of bounds
        checkElementIndex(index);
        // Modify the data
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    // Utility methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Resize the array to newCap
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }


    // Check if the index position can hold an element
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }


    // Check if the index position can add an element
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }


    public static void main(String[] args) {
        // Set initial capacity to 3
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // Add 5 elements
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

}