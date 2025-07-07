package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    // input an array, convert it to a singly linked list
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        return head;
    }
    public static void printList(ListNode head) {
        for(ListNode p = head; p != null; p = p.next){
            System.out.println(p.val);
        }
    }
}


