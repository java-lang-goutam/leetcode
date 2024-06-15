class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        final PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        final PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i=0, n = profits.length; i < n; i++) {
            pqCap.offer(new int[]{capital[i], profits[i]});
        }
        
        for (int i=0; i<k; i++) {
            
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= w) {
                pqPro.offer(pqCap.poll());
            }
            
            if (pqPro.isEmpty()) break;
            
            w += pqPro.poll()[1];
        }
        
        return w;
        
    }
}