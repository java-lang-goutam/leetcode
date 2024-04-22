class Solution {

    private char getNextChar(final char c) {
        switch (c) {
            case '0':
                return '1';
            case '1':
                return '2';
            case '2':
                return '3';
            case '3':
                return '4';
            case '4':
                return '5';
            case '5':
                return '6';
            case '6':
                return '7';
            case '7':
                return '8';
            case '8':
                return '9';
            case '9':
                return '0';
        }

        return '\0';
    }

    private char getPrevChar(final char c) {
        switch (c) {
            case '0':
                return '9';
            case '1':
                return '0';
            case '2':
                return '1';
            case '3':
                return '2';
            case '4':
                return '3';
            case '5':
                return '4';
            case '6':
                return '5';
            case '7':
                return '6';
            case '8':
                return '7';
            case '9':
                return '8';
        }

        return '\0';
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
                final String wheelPos = queue.poll();
                final StringBuilder newPos = new StringBuilder(wheelPos);
                for (int pos = 0; pos < 4; pos++) {
                    final char posChar = wheelPos.charAt(pos);

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
