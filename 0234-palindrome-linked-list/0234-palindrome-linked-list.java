/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val +" -> ");
            head= head.next;
        }
        
        System.out.println("null");
    }
    
    public boolean isPalindrome(ListNode head) {
        
        // divide the list in to halves using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list from slow next as slow is half no of nodes
        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            final ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge the two list to one
        ListNode head1 = head, head2 = prev;
        //print(head1);
        //print(head2);
        
        while(head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
}