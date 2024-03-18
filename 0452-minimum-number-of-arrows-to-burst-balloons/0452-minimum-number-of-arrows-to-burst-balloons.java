class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        System.out.println(Arrays.deepToString(points));

        int size = 1;
        int[] lastProcessed = points[0];

        for (int i = 1, length = points.length; i < length; i++) {
            final int[] point = points[i];
            
            // System.out.println("point: " +  Arrays.toString(point));
            // System.out.println("lastProcessed: " +  Arrays.toString(lastProcessed));
            // System.out.println(lastProcessed[1] < point[0]);

            // no interaction
            if (lastProcessed[1] < point[0]) {
                lastProcessed = point;
                size++;
            } else {
                lastProcessed[0] = Math.max(lastProcessed[0], point[0]);
                lastProcessed[1] = Math.min(lastProcessed[1], point[1]);
            }
        }

        return size;
    }
}
