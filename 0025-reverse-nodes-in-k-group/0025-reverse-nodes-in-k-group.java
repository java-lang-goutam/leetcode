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
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public ListNode reverse(final ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, temp = new ListNode(0, head), prev = temp;

        while (curr != null) {
            //print(temp.next);
            int i;
            ListNode oldHead = curr;
            for (i = 1; i < k && curr != null; i++) {
                curr = curr.next;
            }

            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                prev.next = reverse(oldHead);
                prev = oldHead;
                curr = next;
                prev.next = curr;
            } else {
                break;
            }
        }

        return temp.next;
    }
}
