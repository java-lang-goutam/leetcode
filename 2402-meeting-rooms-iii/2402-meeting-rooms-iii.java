class Solution {

    public int mostBooked(int n, int[][] meetings) {
        if (n == 1) return 0;

        Arrays.sort(meetings, (a1, a2) -> a1[0] - a2[0]);

        System.out.println(Arrays.deepToString(meetings));

        // [] -> 0 : time, 1 : endtime, 2 : room
        final PriorityQueue<int[]> rooms = new PriorityQueue<>(
            (a1, a2) -> {
                final int res = a1[1] - a2[1];
                if (res == 0) return a1[2] - a2[2];
                return res;
            }
        );

        final PriorityQueue<Integer> vacantRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) vacantRooms.offer(i);

        final int[] occupanyCount = new int[n];
        final int length = meetings.length;
        rooms.offer(new int[] { meetings[0][0], meetings[0][1], vacantRooms.poll() });

        for (int i = 1; i < length; i++) {
            final int[] currentMeet = meetings[i];
            int[] latestMeet = rooms.peek();
            int diff = currentMeet[0] - latestMeet[1];

            while (diff >= 0) {
                int lastVacant = latestMeet[2];
                vacantRooms.offer(lastVacant);
                occupanyCount[lastVacant]++;
                rooms.poll();
                if (rooms.isEmpty()) break;
                latestMeet = rooms.peek();
                diff = currentMeet[0] - latestMeet[1];
            }

            if (rooms.isEmpty()) {
                rooms.offer(new int[] { currentMeet[0], currentMeet[1], vacantRooms.poll() });
            } else {
                if (!vacantRooms.isEmpty()) {
                    rooms.offer(new int[] { currentMeet[0], currentMeet[1], vacantRooms.poll() });
                } else {
                    rooms.poll();
                    int lastVacant = latestMeet[2];
                    vacantRooms.offer(lastVacant);
                    occupanyCount[lastVacant]++;
                    rooms.offer(new int[] { currentMeet[0] - diff, currentMeet[1] - diff, vacantRooms.poll() });
                }
            }
        }

        while (!rooms.isEmpty()) {
            final int[] currRoom = rooms.poll();
            occupanyCount[currRoom[2]]++;
        }

        //System.out.println(Arrays.toString(occupanyCount));

        int max = Integer.MIN_VALUE, res = 0;
        for (int i = 0; i < n; i++) {
            if (max < occupanyCount[i]) {
                max = occupanyCount[i];
                res = i;
            }
        }

        return res;
    }
}
