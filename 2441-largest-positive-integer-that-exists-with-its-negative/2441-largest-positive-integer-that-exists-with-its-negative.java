class Solution {

    public int findMaxK(int[] nums) {
        int ans = -1;
        final BitSet seen = new BitSet(2048);
        for (int num : nums) {
            final int abs = Math.abs(num);
            if (abs > ans && seen.get(-num + 1024)) ans = abs;
            seen.set(num + 1024);
        }
        return ans;
    }
}
