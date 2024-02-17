class Solution {

    public int furthestBuildingUsingPQ(int[] height, int bricks, int ladders) {

        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        final int length = height.length;

        for (int i = 1; i < length; i++) {
            int currentHeight = height[i];
            int previousHeight = height[i - 1];
            int difference = currentHeight - previousHeight;
            if (difference > 0) {
                bricks -= difference;
                priorityQueue.offer(difference);

                if (bricks < 0) {
                    final int largestDiff = priorityQueue.poll();
                    ladders--;
                    bricks += largestDiff;
                    if (ladders < 0)
                        return i - 1;
                }

            }

        }

        return length - 1;

    }

    // recursion - not optimal
    public int furthestBuilding(int[] height, int bricks, int ladders, int i) {
        if (i == height.length)
            return i;

        final int currentHeight = height[i];
        final int prevHeight = height[i - 1];

        if (currentHeight <= prevHeight)
            return furthestBuilding(height, bricks, ladders, i + 1);

        final int difference = currentHeight - prevHeight;
        int usingBricks = i, usingLadders = i;
        if (bricks > 0 && difference < bricks) {
            usingBricks = furthestBuilding(height, bricks - difference, ladders, i + 1);
        }
        if (ladders > 0) {
            usingLadders = furthestBuilding(height, bricks, ladders - 1, i + 1);
        }

        return Math.max(usingBricks, usingLadders);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return furthestBuildingUsingPQ(heights, bricks, ladders);
    }
}