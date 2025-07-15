public class SimpleMinPQ {
    // use array to create a heap
    int[] heap;

    // the size of the heap
    int size;

    // initialize a heap array
    public SimpleMinPQ(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    // the index of the parent node
    public int parent(int node){
        return (node - 1)/2;
    }

    // the index of the left child node
    public int left(int node){
        return node * 2 + 1;
    }

    // the index of the right child node
    public int right(int node){
        return node * 2 + 2;
    }

    // swap two elements in the heap
    public void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int size(){
        return size;
    }

    // peek the top of the heap
    public int peek(){
        return heap[0];
    }

    // insert a new number
    public void push(int x){
        // add the new element at the end of this array
        heap[size] = x;
        // swim the new element to the right position
        swim(size);
        size++;
    }

    // delete the top element
    public int pop(){
        // put the heap bottom to the heap top
        int res = heap[0];
        heap[0] = heap[size-1];
        size--;
        // sink it to the right position
        sink(0);
        return res;
    }

    public void swim(int node){
        while(node > 0 && heap[parent(node)] > heap[node]){
            swap(parent(node), node);
            node = parent(node);
        }
    }

    public void sink(int node){
        // while the node still has at least one child nodes
        while(left(node) < size || right(node) < size){
            int min = node;
            // compare with min rather than node.
            if(left(node) < size && heap[min] > heap[left(node)]){
                // The check `left(node) < size` inside the `if` statement is necessary and not redundant,
                // even though a similar condition appears in the `while` loop.
                // The condition in the `while` loop only determines whether we should enter the loop,
                // but the check inside the `if` ensures we don’t access an out-of-bounds index when comparing values.
                // Without this check, we might access an invalid array index and cause an IndexOutOfBoundsException.
                min = left(node);
            }
            if(right(node) < size && heap[min] > heap[right(node)]){
                min = right(node);
            }
            if(min == node){
                break;
            }
            swap(node, min);
            node = min;
        }
    }

    public static void main(String[] args) {
        SimpleMinPQ pq = new SimpleMinPQ(5);
        pq.push(3);
        pq.push(7);
        pq.push(2);
        pq.push(4);
        pq.push(9);

        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());
        System.out.println(pq.pop());

    }


}





















