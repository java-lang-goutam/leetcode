class Solution {
    
    public boolean isIsomorphic(String s, String t) {
        return verify(s, t) && verify(t, s);
    }

    private boolean verify(String s, String t) {
        final char[] arr = new char[95];

        for (int i = 0, n = s.length(); i < n; i++) {
            final int arrIndex = s.charAt(i) - ' ';
            final char arrVal = arr[arrIndex];

            if (arrVal != '\0') {
                if (arrVal != t.charAt(i)) return false;
            } else {
                arr[arrIndex] = t.charAt(i);
            }
        }

        return true;
    }
}
