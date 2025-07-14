public class HeapNode {
    int val;
    HeapNode left;
    HeapNode right;
    HeapNode parent;

    public HeapNode() {
    }

    public HeapNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

}
