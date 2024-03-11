class Solution {

    public String customSortString(String order, String s) {
        final PriorityQueue<Character> pq = new PriorityQueue<>(
            (c1, c2) -> {
                return order.indexOf(c1) - order.indexOf(c2);
            }
        );

        for (int i = 0, length = s.length(); i < length; i++) {
            pq.offer(s.charAt(i));
        }

        final StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());

        return sb.toString();
    }
}
