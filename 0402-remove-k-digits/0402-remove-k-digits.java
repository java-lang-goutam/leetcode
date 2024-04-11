/**
https://leetcode.com/problems/remove-k-digits/discuss/629860/Java-or-C%2B%2B-or-Python3-or-easy-explanation
*/
class Solution {

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        // to add / remove from both sides
        final Deque<Character> monitonicStack = new LinkedList<>();
        int index = 0, inputK = k;

        // temp leading zero
        monitonicStack.push('0');

        // terminate when k = 0
        outerloop: while (index != num.length()) {
            char currEle = num.charAt(index);
            while (currEle < monitonicStack.peek()) {
                monitonicStack.pop();
                k--;
                
                if (k == 0) break outerloop;
            }
            
            monitonicStack.push(num.charAt(index++));
        }

        // case when every element are same
        while (k-- != 0) {
            monitonicStack.pop();
        }
        
        final StringBuilder result = new StringBuilder(num.length() - inputK + 1);
        
        // remove leading zeros from stack
        while (!monitonicStack.isEmpty()) {
            char val = monitonicStack.pollLast();
            if (val != '0') {
                result.append(val);
                break;
            }
        }

        // add rest elements to result
        while (!monitonicStack.isEmpty()) {
            result.append(monitonicStack.pollLast());
        }
        
        // if we have some value add rest value from num
        if (!result.isEmpty()) {
            for (int i=index; i<num.length(); i++) {
                result.append(num.charAt(i));
            }
            return result.toString();
        }
        
        // if stack is empty
        boolean flag = true;
        while (index < num.length()) {
            if (num.charAt(index) != '0') {
                break;
            } else {
                index++;
            }
        }
        
        while (index < num.length()) {
            result.append(num.charAt(index++));
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}
