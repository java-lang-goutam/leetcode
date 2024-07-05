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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        Integer prevIndex = -1000000, minDiff = Integer.MAX_VALUE, firstIndex = null, criticalPointCount = 0;
        ListNode prev = head;

        for (int i = 1; head.next != null; i++, prev = head, head = head.next) {
            //System.out.printf("prev.val = %d, head.val = %d, head.next.val = %d\n", prev.val, head.val, head.next.val);
            if ((prev.val < head.val && head.val > head.next.val) || (prev.val > head.val && head.val < head.next.val)) {
                //System.out.println("i =" + i);
                if (i - prevIndex < minDiff) minDiff = i - prevIndex;
                prevIndex = i;
                //System.out.println("minDiff = " + minDiff);
                if (firstIndex == null) firstIndex = i;
                criticalPointCount++;
            }
        }

        if (criticalPointCount< 2) return new int[] { -1, -1 };

        return new int[] {minDiff, prevIndex - firstIndex};
    }
}
