class Solution {

    public boolean isIsomorphic(String s, String t) {
        final char[] arr = new char[95];
        final boolean[] visited = new boolean[95];

        for (int i = 0, n = s.length(); i < n; i++) {
            final int arrIndex = s.charAt(i) - ' ';
            final char arrVal = arr[arrIndex];
            final char tVal = t.charAt(i);

            if (arrVal != '\0') {
                if (arrVal != tVal) return false;
            } else {
                final int tIndex = tVal - ' ';
                if (visited[tIndex]) return false; else {
                    arr[arrIndex] = tVal;
                    visited[tIndex] = true;
                }
            }
            //System.out.println(Arrays.toString(arr));
        }

        return true;
    }
}
