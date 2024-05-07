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
    
    public int mulBy2(ListNode node) {
        if (node == null) return 0;
        final int mulVal = node.val * 2 + mulBy2(node.next);
        node.val = mulVal % 10;
        return mulVal / 10;
    }
    
    public ListNode doubleIt(ListNode head) {
        final int carry = mulBy2(head);
        return carry == 0 ? head : new ListNode(carry, head);
    }
}