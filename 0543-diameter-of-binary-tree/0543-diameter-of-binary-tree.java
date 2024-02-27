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
    
    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        findMaxLength(root);
        return result;
    }

    public int findMaxLength(TreeNode root) {
        if (root == null) return 0;

        final int maxLeft = findMaxLength(root.left);
        final int maxRight = findMaxLength(root.right);
        
        result = Math.max(result, maxLeft + maxRight);
        
        return 1 + Math.max(maxLeft, maxRight);
    }
}
