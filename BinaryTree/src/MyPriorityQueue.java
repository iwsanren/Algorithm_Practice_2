import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;
    // <? super T>: Any comparator that can compare T or its superclasses.

    @SuppressWarnings("unchecked")
    // It suppresses compiler warnings related to unchecked type casts, especially when you're using generics and raw types.
    // heap = (T[]) new Object[capacity]; This line causes an unchecked cast warning, because Java doesn’t allow direct creation of generic arrays (new T[] is illegal).
    // So we create a new Object[] and cast it to (T[]) — but the compiler warns:
    // “Unchecked cast from Object[] to T[]”
    public MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        this.heap = (T[]) new Object[capacity];
        size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int node) {
        return (node - 1) / 2;
    }

    private int left(int node){
        return node * 2 + 1;
    }

    private int right(int node){
        return node * 2 + 2;
    }

    private void swap(int i, int j){
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // return the element at the top of the binary heap
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Priority queue underflow");
        }
        return heap[0];
    }

    // insert an element at the top of the binary heap
    public void push(T x){
        // capacity expansion
        if (size == heap.length){
            resize(2 * heap.length);
        }
        heap[size] = x;
        swim(size);
        size++;
    }

    // delete the element of the top of the binary heap
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        T res = heap[0];
        // 把堆底元素放到堆顶
        swap(0, size - 1);
        // 避免对象游离
        heap[size - 1] = null;
        size--;
        // 然后下沉到正确位置
        sink(0);
        // 缩容
        if ((size > 0) && (size == heap.length / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }

    private void swim(int node){
        while (node > 0 && comparator.compare(heap[parent(node)], heap[node]) > 0){
            swap(parent(node), node);
            node = parent(node);
        }
    }

    private void sink(int node){
        while(left(node) < size || right(node) < size){
            int min = node;
            if(left(node) < size && comparator.compare(heap[min], heap[left(min)]) > 0){
                min = left(node);
            }
            if (right(node) < size && comparator.compare(heap[right(node)], heap[min]) < 0) {
                min = right(node);
            }
            if (min == node) {
                break;
            }
            swap(node, min);
            node = min;
        }
    }

    // modify the size of the heap
    @SuppressWarnings("unchecked")
    private void resize(int capacity){
        assert capacity > size;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }


}
