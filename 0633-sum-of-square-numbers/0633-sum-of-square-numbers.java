class Solution {

    public boolean judgeSquareSum(int c) {
        final Set<Integer> squareNumbers = new HashSet<>();
        final long N = (long) c;

        for (long i = 0L; i * i <= N; i++) {
            squareNumbers.add((int) (i * i));
        }

        for (int n : squareNumbers) {
            if (squareNumbers.contains(c - n)) return true;
        }

        return false;
    }
}
