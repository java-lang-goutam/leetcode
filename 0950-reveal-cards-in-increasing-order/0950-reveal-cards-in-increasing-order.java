class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        final Queue<Integer> queue = new LinkedList<>();
        final int size = deck.length;

        for (int i = 0; i < size; i++) {
            queue.offer(i);
        }

        Arrays.sort(deck);

        final int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }

        return result;
    }
}
