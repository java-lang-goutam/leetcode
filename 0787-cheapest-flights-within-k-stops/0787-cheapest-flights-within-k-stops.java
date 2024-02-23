class Solution {
    
    private final int INF = Integer.MAX_VALUE;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        final List[] adj = new List[n];
        final int[] dist = new int[n];
        
        for (int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }
        
        for (int[] flight : flights) {
            adj[flight[0]].add(flight);
        }

        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});

        while (!q.isEmpty() && k-- >= 0) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int distance = curr[1];
                final List<int[]> neighbours = adj[node];

                for (int[] next : neighbours) {
                    int neighbour = next[1];
                    int price = next[2];
                    if (price + distance >= dist[neighbour]) continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] {neighbour, dist[neighbour]});
                }
            }
        }

        return dist[dst] == INF ? -1 : dist[dst];
    }
}