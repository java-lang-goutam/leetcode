class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        final Map<Integer, Integer> eleFrequency = new HashMap<>();

        for (final int ele : arr) {
            eleFrequency.compute(ele, (key, val) -> val == null ? 1 : 1 + val);
        }

        int totalUniqueElements = eleFrequency.size();

        final Iterator<Map.Entry<Integer, Integer>> iterator = eleFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .iterator();

        while (k > 0 && iterator.hasNext()) {
            totalUniqueElements--;
            k -= iterator.next().getValue();
        }

        return k < 0 ? 1 + totalUniqueElements : totalUniqueElements;
    }
}