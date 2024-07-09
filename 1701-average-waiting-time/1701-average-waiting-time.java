class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        long totalWaitingTime = 0, currentTime = 0;
        
        for (final int[] customer : customers) {
            final int arrivalTime = customer[0];
            currentTime = Math.max(currentTime, arrivalTime) + customer[1];
            totalWaitingTime += currentTime - arrivalTime;
        }
        
        return (totalWaitingTime * 1.0) / customers.length;
    }
}