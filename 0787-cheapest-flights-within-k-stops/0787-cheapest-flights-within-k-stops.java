class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final List[] adjacency = new List[n];
        final int[] minimumDistance = new int[n];
        final int INF = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            adjacency[i] = new ArrayList<int[]>();
            minimumDistance[i] = INF;
        }

        // Create adjacency metrics
        for (final int[] flight : flights) {
            adjacency[flight[0]].add(flight);
        }

        final Queue<int[]> queue = new LinkedList<>();
        minimumDistance[src] = 0;
        queue.offer(new int[] { src, 0 });

        while (!queue.isEmpty() && k-- >= 0) {
            int totalElementsWithSameStep = queue.size();
            while (totalElementsWithSameStep-- > 0) {
                final int[] pair = queue.poll();
                final int node = pair[0];
                final int distanceSoFar = pair[1];
                final List<int[]> neighbours = adjacency[node];

                for (final int[] neighbour : neighbours) {
                    final int toNode = neighbour[1];
                    final int newDistance = neighbour[2] + distanceSoFar;

                    if (minimumDistance[toNode] > newDistance) {
                        minimumDistance[toNode] = newDistance;
                        queue.offer(new int[] { toNode, newDistance });
                    }
                }
            }
        }

        return minimumDistance[dst] == INF ? -1 : minimumDistance[dst];
    }
}
