class Solution {

    /**
     * Credits : https://www.youtube.com/watch?v=-qrpJykY2gE
     */
    public int rangeBitwiseAnd(int left, int right) {

        int bitsFlipped = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            bitsFlipped++;
        }

        return left << bitsFlipped;
    }
}