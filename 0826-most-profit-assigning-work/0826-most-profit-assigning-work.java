class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i=0, n= profit.length; i < n; i++) {
            final Integer p = profit[i];
            treeMap.compute(difficulty[i], (k, v) -> v == null ? p : Math.max(p, v));
        }
        
        int maxProfits = 0, maxValueSoFar = 0;
        
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            final Integer diff = entry.getKey();
            final Integer pro = entry.getValue();
            maxValueSoFar = Math.max(maxValueSoFar, pro);
            treeMap.put(diff, maxValueSoFar);
        }
        
        for (final int workerDifficulty : worker) {
            final Map.Entry<Integer, Integer> entry = treeMap.floorEntry(workerDifficulty);
            if (entry != null) maxProfits += entry.getValue();
        }
        
        return maxProfits;
        
    }
}