class Solution {

    public int furthestBuildingUsingPQ(int[] height, int bricks, int ladders) {

        // max heap
        final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        final int length = height.length;

        for (int i = 1; i < length; i++) {
            int currentHeight = height[i];
            int previousHeight = height[i - 1];
            int difference = currentHeight - previousHeight;
            if (difference > 0) {
                bricks -= difference;
                priorityQueue.offer(difference);

                // If all bricks are exhausted
                if (bricks < 0) {

                    // max bricks used so far
                    final int largestDiff = priorityQueue.poll();
                    ladders--;

                    // reclaim max bricks
                    bricks += largestDiff;

                    // if ladders are exhausted
                    if (ladders < 0)

                        // since we moving advance and comparing with prev building
                        return i - 1;
                }
            }
        }

        return length - 1;

    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return furthestBuildingUsingPQ(heights, bricks, ladders);
    }
}