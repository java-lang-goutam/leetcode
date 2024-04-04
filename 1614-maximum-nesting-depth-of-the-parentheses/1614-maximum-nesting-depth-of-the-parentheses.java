class Solution {

    public int maxDepth(String s) {
        int count = 0, maxCount = 0;

        for (int i = 0, length = s.length(); i < length; i++) {
            final char currChar = s.charAt(i);
            if (currChar == '(') {
                count++;
                if (maxCount < count) maxCount = count;
            } else if (currChar == ')') {
                count--;
            }
        }

        return maxCount;
    }
}
