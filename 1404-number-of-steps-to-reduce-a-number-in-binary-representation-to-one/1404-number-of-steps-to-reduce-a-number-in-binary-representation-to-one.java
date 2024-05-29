class Solution {

    public String addOne(String s) {
        final StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, '1');
                break;
            }
        }
        return sb.charAt(0) == '0' ? '1' + sb.toString() : sb.toString();
    }

    public int numSteps(String s) {
        int steps = 0;
        while (!s.equals("1")) {
            // if odd
            if (s.charAt(s.length() - 1) == '1') {
                s = addOne(s);
            } else {
                s = s.substring(0, s.length() - 1);
            }

            steps++;
        }

        return steps;
    }
}
