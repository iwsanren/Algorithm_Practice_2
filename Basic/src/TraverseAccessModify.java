import org.junit.Test;
import utils.*;

public class TraverseAccessModify {
    /*
    traverse each node in a singly linked list and print the value
     */
    @Test
    public void testTraverse(){
        // create a single linked list
        ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});

        // traverse the singly linked list
//        for(ListNode p = head; p != null; p = p.next){
//            System.out.println(p.val);
//        }
        ListNode.printList(head);
    }

    /*
    insert the new node before the head node and set the new node as the head
     */
    @Test
    public void testInsert(){
        ListNode head = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});

        // insert a new node with value 0 at the head of the single linked list
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        head = newNode;

        ListNode.printList(head);
    }


}
