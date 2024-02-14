class Solution {
    public int[] rearrangeArray(int[] nums) {

        final int length = nums.length;
        final int[] rearrangedArray = new int[length];
        int positiveIndex = 0, negativeIndex = 1;

        for (int i=0; i<length; i++) {
            final int currentNumber = nums[i];
            if (currentNumber > 0) {
                rearrangedArray[positiveIndex] = currentNumber;
                positiveIndex += 2;
            } else {
                rearrangedArray[negativeIndex] = currentNumber;
                negativeIndex += 2;
            }
        }

        return rearrangedArray;
    }
}