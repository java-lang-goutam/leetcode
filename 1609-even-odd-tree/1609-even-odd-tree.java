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

    public boolean isEvenOddTree(TreeNode root) {
        final Map<Integer, Integer> levelValues = new HashMap<>();
        return isEvenOddTree(root, 0, levelValues);
    }

    private boolean isEvenOddTree(final TreeNode root, final int level, final Map<Integer, Integer> levelValues) {
        final boolean isOddLevel = (level & 1) == 1;
        final boolean isOddValue = (root.val & 1) == 1;
        final Integer levelLastValue = levelValues.get(level);

        if (isOddLevel) {
            if (!isOddValue && (levelLastValue == null || levelLastValue > root.val)) {
                levelValues.put(level, root.val);
            } else {
                return false;
            }
        } else {
            if (isOddValue && (levelLastValue == null || levelLastValue < root.val)) {
                levelValues.put(level, root.val);
            } else {
                return false;
            }
        }

        final boolean isLeftChildEvenOddTree = root.left == null || isEvenOddTree(root.left, level + 1, levelValues);
        final boolean isRightChildEvenOddTree = root.right == null || isEvenOddTree(root.right, level + 1, levelValues);

        return isLeftChildEvenOddTree && isRightChildEvenOddTree;
    }
}
