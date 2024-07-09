class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        long totalWaitingTime = 0, currentTime = 0;
        
        for (final int[] customer : customers) {
            currentTime = Math.max(currentTime, customer[0]) + customer[1];
            totalWaitingTime += currentTime - customer[0];
        }
        
        return (totalWaitingTime * 1.0) / customers.length;
    }
}