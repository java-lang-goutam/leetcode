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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        TreeNode tempNode = new TreeNode(0, root, null);
        tempNode.left = add(root, val, depth - 1, true);
        return tempNode.left;
    }

    private TreeNode add(final TreeNode node, final int val, final int depth, final boolean isLeft) {
        if (depth == 0) {
            final TreeNode newNode = new TreeNode(val);
            if (isLeft) newNode.left = node; else newNode.right = node;
            return newNode;
        }

        if (node == null) return null;

        node.left = add(node.left, val, depth - 1, true);
        node.right = add(node.right, val, depth - 1, false);

        return node;
    }
}
