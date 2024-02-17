class Solution {

    class Student {
        int id;
        int point;

        Student(int id, int point) {
            this.id = id;
            this.point = point;
        }
    }

    public List<Integer> topStudents(String[] positiveFeedbacks, String[] negativeFeedbacks, String[] reports,
            int[] studentIds, int k) {

        final int totalStudents = studentIds.length;
        final Map<Integer, Integer> studentPoint = new HashMap<>();
        final PriorityQueue<Student> queue = new PriorityQueue<>((student1, student2) -> {
            final int pointDiff = student1.point - student2.point;
            if (pointDiff == 0) {
                return student2.id - student1.id;
            }
            return pointDiff;
        });

        final Set<String> positiveSet = Arrays.stream(positiveFeedbacks).collect(Collectors.toSet());
        final Set<String> negativeSet = Arrays.stream(negativeFeedbacks).collect(Collectors.toSet());

        for (int i = 0; i < totalStudents; i++) {

            final int studentId = studentIds[i];
            final String report = reports[i];
            int commulativePoint = 0;
            for (final String word : report.split(" ")) {
                if (positiveSet.contains(word))
                    commulativePoint += 3;
                else if (negativeSet.contains(word))
                    commulativePoint--;
            }

            final Student student = new Student(studentId, commulativePoint);
            queue.offer(student);

            if (queue.size() > k)
                queue.poll();
        }

        final LinkedList<Integer> results = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            final Student student = queue.poll();
            results.addFirst(student.id);
        }

        return results;
    }
}