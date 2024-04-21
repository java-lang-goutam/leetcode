class UnionFind {
    private final int N;
    private final int[] parent;
    private final int[] size;

    public UnionFind(final int N) {
        this.N = N;
        this.parent = new int[N];
        this.size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(final int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(final int x, final int y) {
        final int parentX = find(x);
        final int parentY = find(y);
        
        if (parentX == parentY) return;
        
        if (size[x] <= size[y]) {
            parent[parentX] = parentY;
            size[parentY] += size[parentX];
        } else {
            parent[parentY] = parentX;
            size[parentX] += size[parentY];
        }
    }
}

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final UnionFind unionFind = new UnionFind(n);
        for (final int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        
        return unionFind.find(source) == unionFind.find(destination);
    }
}
