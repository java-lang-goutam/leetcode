class Solution {
    public String maximumOddBinaryNumber(final String s) {
        
        final StringBuilder sb = new StringBuilder();
        for (int i=0, length = s.length(); i < length; i++) {
            final char c = s.charAt(i);
            if (c == '0') {
                sb.append(c);
            } else {
                sb.insert(0, c);
            }
        }
        
        // remove first character and add to last
        final char firstChar = sb.charAt(0);
        sb.deleteCharAt(0);
        return sb.append(firstChar).toString();
    }
}