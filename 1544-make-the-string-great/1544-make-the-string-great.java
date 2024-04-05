class Solution {

    private boolean check(final int c1, final int c2) {
        final int diff = c1 - c2;
        return diff == 32 || diff == -32;
    }

    public String makeGood(String s) {
        final StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0, length = s.length(); i < length; i++) {
            final char c = s.charAt(i);
            final int lastIndex = sb.length() - 1;
            if (lastIndex == -1 || !check(sb.charAt(lastIndex), c)) sb.append(c); 
            else sb.deleteCharAt(lastIndex);
        }

        return sb.toString();
    }
}
