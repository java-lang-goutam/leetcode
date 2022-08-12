
class Solution {

    private class CarStatus {
        int speed, position, steps;

        CarStatus(int speed, int position, int steps) {
            this.speed = speed;
            this.position = position;
            this.steps = steps;
        }

        String getHash() {
            return speed + " " + position;
        }

        CarStatus accelerate() {
            return new CarStatus(speed << 1, speed + position, steps + 1);
        }

        CarStatus reverse() {
            return new CarStatus(speed > 0 ? -1 : 1, position, steps + 1);
        }
    }


    public int racecar(int target) {
        final int maxTarget = target << 1;
        final Queue<CarStatus> queue = new LinkedList<>();
        final CarStatus first = new CarStatus(1, 0, 0);
        final Set<String> visited = new HashSet<>();
        queue.offer(first);
        visited.add(first.getHash());

        while (!queue.isEmpty()) {

            final CarStatus currStatus = queue.poll();
            if (currStatus.position == target) return currStatus.steps;

            // accelerate
            final CarStatus accStatus = currStatus.accelerate();
            if (!visited.contains(accStatus.getHash()) && 
                accStatus.position > 0 && accStatus.position < maxTarget) {
                 
                visited.add(accStatus.getHash());
                queue.offer(accStatus);
            }

            // reverse
            final CarStatus revStatus = currStatus.reverse();
            if (!visited.contains(revStatus.getHash()) && 
                revStatus.position > 0 && revStatus.position < maxTarget) {
                 
                visited.add(revStatus.getHash());
                queue.offer(revStatus);
            }
        }

        return -1;
    }
}
