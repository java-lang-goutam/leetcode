class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // Counter array to store the frequency of each task
        int[] counter = new int[26];
        int maximum = 0;
        int maxCount = 0;

        // Traverse through tasks to calculate task frequencies
        for (char task : tasks) {
            final int index = task - 'A';
            counter[index]++;
            final int value = counter[index];
            
            if (maximum == value) {
                maxCount++;
            }
            else if (maximum < value) {
                maximum = value;
                maxCount = 1;
            }
        }
        
        int time = (maximum - 1) * (n + 1) + maxCount;
        return Math.max(time, tasks.length);
    }
}