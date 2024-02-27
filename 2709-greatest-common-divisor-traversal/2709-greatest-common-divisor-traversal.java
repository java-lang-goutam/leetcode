public class UnionFind {
    final int N;
    final int[] parent;
    final int[] size;

    public UnionFind(final int N) {
        this.N = N;
        this.parent = new int[N];
        this.size = new int[N];

        for (int i = 1; i < N; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(final int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public void union(final int x, final int y) {
        final int rootX = find(x);
        final int rootY = find(y);

        if (rootX == rootY) return;

        if (size[rootX] > size[rootY]) {
            size[rootX] += size[rootY];
            parent[rootY] = rootX;
        } else {
            size[rootY] += size[rootX];
            parent[rootX] = rootY;
        }
    }
}

class Solution {
    private static final int MAX_LENGTH = (int) 1e5 + 1;
    private static final int[] primeFactors = buildSeive();

    private static int[] buildSeive() {
        final int[] primeFactors = new int[MAX_LENGTH];

        for (int i = 1; i < MAX_LENGTH; i += 2) {
            primeFactors[i] = i;
        }

        for (int i = 2; i < MAX_LENGTH; i += 2) {
            primeFactors[i] = 2;
        }

        for (int i = 3; i * i < MAX_LENGTH; i += 2) {
            if (primeFactors[i] == i) {
                for (int j = i * i; j < MAX_LENGTH; j += i) {
                    primeFactors[j] = i;
                }
            }
        }

        return primeFactors;
    }

    public static Set<Integer> getPrimeFactors(int num) {
        final Set<Integer> factors = new HashSet<>();

        while (num > 1) {
            final int factor = primeFactors[num];
            factors.add(factor);
            num /= factor;
        }
        return factors;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        final int length = nums.length;
        if (length == 1) return true;
        final UnionFind uf = new UnionFind(MAX_LENGTH);
        for (int num : nums) {
            if (num == 1) return false;
            final Set<Integer> primeFactors = getPrimeFactors(num);
            primeFactors.forEach(factor -> uf.union(factor, num));
        }

        final int rootValue = uf.find(nums[0]);

        for (int i = 1; i < length; i++) {
            if (rootValue != uf.find(nums[i])) {
                return false;
            }
        }

        return true;
    }
}
