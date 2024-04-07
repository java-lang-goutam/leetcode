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
        final int length = lists.length;
        if (length == 0) return null;

        ListNode curr = lists[0];

        for (int i = 1; i < length; i++) {
            if (lists[i] != null) curr = merge(curr, lists[i]);
        }

        return curr;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        final ListNode temp = new ListNode();
        ListNode curr = temp;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return temp.next;
    }
}
