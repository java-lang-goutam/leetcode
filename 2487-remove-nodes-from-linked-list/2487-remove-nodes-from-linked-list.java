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

    public ListNode removeNodes(ListNode curr, ListNode prev) {
        if (curr == null) return new ListNode(0);
        final ListNode nextMax = removeNodes(curr.next, curr);
        if (curr.val >= nextMax.val) return curr;
        if (prev != null) prev.next = curr.next;
        return nextMax;
    }

    public ListNode removeNodes(ListNode head) {
        return removeNodes(head, null);
    }
}
