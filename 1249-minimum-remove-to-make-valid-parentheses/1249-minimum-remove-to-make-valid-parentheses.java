class Solution {

    public String minRemoveToMakeValid(String s) {
        final Deque<int[]> deque = new LinkedList<>();
        final int length = s.length();

        deque.offer(new int[] { '\0', -1 });

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                deque.offerLast(new int[] { '(', i });
            } else if (s.charAt(i) == ')') {
                if (deque.peekLast()[0] == '(') deque.pollLast(); else deque.offerLast(new int[] { ')', i });
            }
        }

        deque.pollFirst();
        final StringBuilder sb = new StringBuilder(s.length() - deque.size() + 1);
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && deque.peekFirst()[1] == i) {
                deque.pollFirst();
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
