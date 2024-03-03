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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        ListNode current = head;

        for (int i=0; i<n; i++) current = current.next;
    
        ListNode prev = null, slow=head;
        while(current != null){
            current = current.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) return head.next;
        prev.next = prev.next.next;

        return head;
    }
}