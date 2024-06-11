class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = arr2.length; i < n; i++) map.put(arr2[i], i);

        final PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));
        final PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (final int ele : arr1) {
            if (map.containsKey(ele)) pq1.offer(ele); 
            else pq2.offer(ele);
        }

        final int[] result = new int[arr1.length];
        for (int i = 0, n = result.length; i < n; i++) {
            if (!pq1.isEmpty()) result[i] = pq1.poll(); else result[i] = pq2.poll();
        }

        return result;
    }
}
