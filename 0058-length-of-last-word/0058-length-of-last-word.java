class Solution {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // move the end curtsor till last valid character
        while (i >= 0 && s.charAt(i--) == ' ');

        // 1 since i is already moved from the non space position
        int count = 1;
        while (i >= 0) {
            if (s.charAt(i--) == ' ') return count;
            count++;
        }

        return count;
    }
}
