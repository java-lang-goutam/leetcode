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
        
        // Calculate idle slots, available tasks, and idles needed
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maximum * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}