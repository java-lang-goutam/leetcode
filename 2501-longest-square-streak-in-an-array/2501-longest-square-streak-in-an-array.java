class Solution {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        final Map<Integer, Integer> startStreakCount = new HashMap<>();
        int longestStreak = 1;

        for (int num : nums) {
            final int sqrt = (int) Math.sqrt(num);

            // if perfect square
            if (sqrt * sqrt == num && startStreakCount.containsKey(sqrt)) {
                int streakCount = startStreakCount.get(sqrt) + 1;
                longestStreak = Math.max(longestStreak, streakCount);

                startStreakCount.put(num, streakCount);
            } else {
                startStreakCount.put(num, 1);
            }
        }

        return longestStreak == 1 ? -1 : longestStreak;
    }
}
