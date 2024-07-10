class Solution {
    public int findTheWinner(int n, int k) {
        
        final Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
        
        while (deque.size() > 1) {
            for (int i=1; i<k; i++) deque.offer(deque.pollFirst());   
            deque.pollFirst();
        }
        
        return deque.poll();
        
    }
}