public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // input an array, convert it to a singly linked list
    ListNode createLinkedList(int[] arr){
        if(arr == null || arr.length == 0){
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
}
