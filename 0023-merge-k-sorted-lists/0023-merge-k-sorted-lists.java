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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        final PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (n1, n2) -> {
                return n1.val - n2.val;
            }
        );

        for (final ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        final ListNode tempHead = new ListNode();
        ListNode curr = tempHead;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null) pq.offer(curr.next);
        }

        return tempHead.next;
    }
}
