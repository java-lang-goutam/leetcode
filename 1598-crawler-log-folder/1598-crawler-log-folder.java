class Solution {

    public int minOperations(String[] logs) {
        
        int count = 0;
        for (String log : logs) {
            if ("./".equals(log)) continue;

            if ("../".equals(log)) {
                count = Math.max(0, count - 1);
            } else {
                count++;
            }
        }

        return count;
    }
}
