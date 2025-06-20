import java.util.ArrayList;

public class DynamicArray {
    public static void main(String[] args) {
        /*
        create a dynamic array
        no need to explicitly specify the array size, it will automatically
        resize based on the number of elements stored.
         */
        ArrayList<Integer> arr = new ArrayList<>();

        // append elements at the end of the array, time complexity O(1)
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }

        // insert an element at a specific index, time complexity O(n)
        // insert element 66 at index2
        arr.add(2,66);

        // insert elements at the beginning, time complexity O(N)
        arr.add(0, -1);

        // remove the last element, time complexity O(1)
        arr.remove(arr.size()-1);

        // query element by index
        int a = arr.get(2);

        // modify element by index
        arr.set(0,100);

        // find index by element value
        int index = arr.indexOf(66);

    }
}
