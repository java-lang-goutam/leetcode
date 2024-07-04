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

    public ListNode mergeNodes(ListNode head) {
        final ListNode temp = new ListNode();
        ListNode curr = temp, prev = null;
        while (head != null) {
            if (head.val == 0) {
                prev = curr;
                curr.next = new ListNode();
                curr = curr.next;
            } else {
                curr.val += head.val;
            }
            head = head.next;
        }

        prev.next = null;
        return temp.next;
    }
}
