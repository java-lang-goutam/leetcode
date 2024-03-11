class Solution {

    public String customSortString(String order, String s) {
        final int[] count = new int[26];

        for (int i = 0, length = s.length(); i < length; i++) {
            count[s.charAt(i) - 'a']++;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0, length = order.length(); i < length; i++) {
            final char c = order.charAt(i);
            final int index = c - 'a';
            for (int j = 0, total = count[index]; j < total; j++) {
                sb.append(c);
            }
            count[index] = 0;
        }

        for (int i = 0; i < 26; i++) {
            final int total = count[i];
            if (total > 0) {
                final char c = (char) ('a' + i);
                for (int j = 0; j < total; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
