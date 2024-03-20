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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode src = list1, des = null;
        for (int i = 0, n = a - 1; i < n; src = src.next, i++) {}

        des = src.next;
        src.next = list2;

        for (int i = a; i < b; i++, des = des.next) {}

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = des.next;
        return list1;
    }
}
