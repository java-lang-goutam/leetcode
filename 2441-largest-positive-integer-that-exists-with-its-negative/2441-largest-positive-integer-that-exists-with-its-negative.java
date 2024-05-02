class Solution {

    public int findMaxK(int[] nums) {
        
        int ans = -1;
        final boolean[] visited = new boolean[2048];
        for (int num : nums) {
            final int abs = Math.abs(num);
            if (abs > ans && visited[-num + 1024]) ans = abs;
            visited[num + 1024] = true;
        }
        return ans;
    }
}
