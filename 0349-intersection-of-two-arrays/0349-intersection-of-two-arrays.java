class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        final Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        final List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.remove(num)) list.add(num);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
