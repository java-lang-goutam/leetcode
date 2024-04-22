class Solution {

    private char getNextChar(final char c) {
        if (c == '9') return '0';
        return (char) (c + 1);
    }

    private char getPrevChar(final char c) {
        if (c == '0') return '9';
        return (char) (c - 1);
    }

    public int openLock(String[] deadends, String target) {
        
        final String start = "0000";
        
        if (start.equals(target)) return 0;

        final Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        final Queue<String> queue = new LinkedList<>();

        if (!visited.contains(start)) queue.offer("0000");
        int count = 0, size = 1;

        while ((size = queue.size()) > 0) {
            count++;
            for (int i = 0; i < size; i++) {
                final StringBuilder newPos = new StringBuilder(queue.poll());
                for (int pos = 0; pos < 4; pos++) {
                    final char posChar = newPos.charAt(pos);

                    // next combination
                    newPos.setCharAt(pos, getNextChar(posChar));
                    final String nextString = newPos.toString();
                    if (target.equals(nextString)) return count;
                    if (!visited.contains(nextString)) {
                        visited.add(nextString);
                        queue.offer(nextString);
                    }

                    // prev combination
                    newPos.setCharAt(pos, getPrevChar(posChar));
                    final String prevString = newPos.toString();
                    if (target.equals(prevString)) return count;

                    if (!visited.contains(prevString)) {
                        visited.add(prevString);
                        queue.offer(prevString);
                    }

                    // revert to normal
                    newPos.setCharAt(pos, posChar);
                }
            }
        }

        return -1;
    }
}
