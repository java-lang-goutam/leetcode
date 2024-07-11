class Solution {
    
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    public String reverseParentheses(String s) {
        
        final Stack<Integer> stack = new Stack<>();
        for (int i=0, n = s.length(); i < n; i++) {
            final char c = s.charAt(i);
            if (c == '(') stack.push(i);
            if (c == ')') {
                final int from = stack.pop();
                s = s.substring(0, from + 1) + reverse(s.substring(from + 1, i)) + s.substring(i, n);
                //System.out.println(s);
            }
        }
        
        return s.replace(")", "").replace("(", "");
    }
}