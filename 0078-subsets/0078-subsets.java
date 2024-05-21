class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        find(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void find(final int[] nums, final int index, final List<List<Integer>> result, final List<Integer> currElements) {
        if (index == nums.length) {
            result.add(currElements);
            return;
        }

        // exclude
        find(nums, index + 1, result, currElements);

        // include
        final List<Integer> newList = new ArrayList<>(currElements);
        newList.add(nums[index]);
        find(nums, index + 1, result, newList);
    }
}
