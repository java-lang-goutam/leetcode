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
    
    private int getSum(final TreeNode root, int currSum) {
        if (root == null) return 0;
        
        final int newSum = currSum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            return newSum;
        }
        
        return getSum(root.left, newSum) + getSum(root.right, newSum);
    }
    
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
}