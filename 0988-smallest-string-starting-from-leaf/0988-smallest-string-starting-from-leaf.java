/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        final String[] result = new String[1];
        smallest(root, "", result);
        return result[0];
    }
    
    public String compare(final String s1, final String s2) {
        
        final int length1 = s1.length(), length2 = s2.length();
        final int n = Math.min(length1, length2);
        int i=0;
        
        while (i < n) {
            final char c1 = s1.charAt(i);
            final char c2 = s2.charAt(i++);
            
            if (c1 < c2) return s1;
            if (c1 > c2) return s2;
        }
        
        return length1 < length2 ? s1 : s2;
    }
    
    private void smallest(final TreeNode root, final String soFar, final String[] result) {

        final String currVal = (char)(root.val + 'a') + soFar;
        
        if (root.left == null && root.right == null) {
            if (result[0] == null) result[0] = currVal;
            else result[0] = compare(result[0], currVal);
            return;
        }
        
        if (root.left != null) {
            smallest(root.left, currVal, result);
        }
        
        if (root.right != null) {
            smallest(root.right, currVal, result);
        }
    }
}