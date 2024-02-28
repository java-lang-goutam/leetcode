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
    int maxLevel = -1;
    int maxValue = 0;

    public void traverse(TreeNode root, int level) {
        if (root == null) return;
        //System.out.println("root : " + root.val + ", level : "+ level);
        traverse(root.left, level + 1);
        if (level > maxLevel) {
            maxLevel = level;
            maxValue = root.val;
            //System.out.println("Setting level");
        }
        traverse(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return maxValue;
    }
}
