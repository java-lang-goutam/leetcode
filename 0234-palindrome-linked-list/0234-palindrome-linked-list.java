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
    public boolean isPalindrome(ListNode head) {
        
        final LinkedList<ListNode> list = new LinkedList<>();
        ListNode curr = head;
        
        int size = 0;
        while (curr != null) {
            size++;
            list.addFirst(curr);
            curr=curr.next;
        }
        
        curr = head;
        final Iterator<ListNode> it = list.listIterator();
        for (int i=0, n = (size >> 1); i<n; i++) {
            if (it.next().val != curr.val) return false;
            curr = curr.next;
        }

        return true;
    }
}