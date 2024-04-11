/**
https://leetcode.com/problems/remove-k-digits/discuss/629860/Java-or-C%2B%2B-or-Python3-or-easy-explanation
*/
class Solution {

    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";

        final Deque<Character> monitonicStack = new LinkedList<>();
        int index = 0, inputK = k;

        // temp leading zero
        monitonicStack.push('0');

        while (index != num.length()) {
            char currEle = num.charAt(index);
            while (currEle < monitonicStack.peek() && k != 0) {
                monitonicStack.pop();
                k--;
            }
            
            monitonicStack.push(num.charAt(index++));
        }

        // case when every element are same
        while (k-- != 0) {
            monitonicStack.pop();
        }
        final StringBuilder result = new StringBuilder(num.length() - inputK + 1);
        while (!monitonicStack.isEmpty()) {
            char val = monitonicStack.pollLast();
            if (val != '0') {
                result.append(val);
                break;
            }
        }

        while (!monitonicStack.isEmpty()) {
            result.append(monitonicStack.pollLast());
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}
