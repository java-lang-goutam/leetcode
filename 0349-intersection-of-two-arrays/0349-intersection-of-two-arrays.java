class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        final int[] count = new int[1001];

        for (int num : nums1) {
            count[num] = 1;
        }

        final List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (count[num]-- == 1) list.add(num);
        }

        final int length = list.size();
        final int[] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}