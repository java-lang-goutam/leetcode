class Solution {

    private boolean check(final char c1, final char c2) {
        return (Character.isUpperCase(c2) && (Character.toLowerCase(c2) == c1)) || 
            (Character.isUpperCase(c1) && (Character.toLowerCase(c1) == c2));
    }

    public String makeGood(String s) {
        final Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1, length = s.length(); i < length; i++) {
            final char c = s.charAt(i);
            if (stack.isEmpty() || !check(stack.peek(), c)) stack.push(c); else stack.pop();
        }

        final StringBuilder sb = new StringBuilder(stack.size());
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}