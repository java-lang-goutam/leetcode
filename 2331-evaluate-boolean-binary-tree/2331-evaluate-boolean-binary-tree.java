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
    
    private final int OR = 2;
    private final int AND = 3;
    private final int TRUE = 1;
    private final int FALSE = 0;
    
    
    public boolean evaluateTree(TreeNode root) {
        if (root.val == TRUE) return true;
        if (root.val == FALSE) return false;
        
        if (root.val == OR) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}