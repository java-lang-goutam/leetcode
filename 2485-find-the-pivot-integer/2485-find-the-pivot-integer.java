class Solution {
    public int pivotInteger(int n) {
        final double val = Math.sqrt((n * (n + 1)) >> 1);
        return Math.floor(val) == val ? (int) val : -1;
    }
}