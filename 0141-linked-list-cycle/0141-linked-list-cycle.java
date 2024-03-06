/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        final int visitedValue = Integer.MAX_VALUE;
        
        while (head != null) {
            if (head.val == visitedValue) return true;
            head.val = visitedValue;
            head = head.next;
        }
        
        return false;
    }
}