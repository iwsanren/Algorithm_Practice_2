public class partitionTwoLists86 {
    public ListNode partition(ListNode head, int x) {
        // dummy head for the list storing nodes less than x
        ListNode dummy1 = new ListNode(-1);
        // dummy head for the list storing nodes greater or equal to x
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;

        // traversing the original list
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            // cannot just move the p pointer forward like this:
            // cur = cur.next
            // break the next pointer of each node in the original list 
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
        }

        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
