class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        for (int i = 0, n = seats.length; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
