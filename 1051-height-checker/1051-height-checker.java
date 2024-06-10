class Solution {
    public int heightChecker(int[] heights) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int h : heights) {
            pq.offer(h);
        }
        
        int i=0, res = 0;
        while (!pq.isEmpty()) {
            if (heights[i++] != pq.poll()) res++;
        }
        
        return res;
    }
}