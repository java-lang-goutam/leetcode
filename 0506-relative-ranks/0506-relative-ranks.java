class Solution {

    public String[] findRelativeRanks(int[] score) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = score.length;

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        Arrays.sort(score);

        final String[] result = new String[n];

        if (n >= 1) result[map.get(score[n - 1])] = "Gold Medal";
        if (n >= 2) result[map.get(score[n - 2])] = "Silver Medal";
        if (n >= 3) result[map.get(score[n - 3])] = "Bronze Medal";

        int pos = 4;
        for (int i = n - 4; i >= 0; i--) {
            result[map.get(score[i])] = String.valueOf(pos++);
        }

        return result;
    }
}
