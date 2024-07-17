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
    
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final Set<Integer> nodesToDelete = new HashSet<>(to_delete.length);
        for(int i=0; i<to_delete.length; i++) {
            nodesToDelete.add(to_delete[i]);
        }
        final List<TreeNode> forestRoots = new ArrayList<>();
        
        if (!nodesToDelete.contains(root.val)) {
            forestRoots.add(root);
        } else {
             if (root.left != null && !nodesToDelete.contains(root.left.val))
                    forestRoots.add(root.left);
                
                if (root.right != null && !nodesToDelete.contains(root.right.val))
                    forestRoots.add(root.right);
        }
        
        _delNodes(root, nodesToDelete, forestRoots);
        return forestRoots;
    }
    
    public void _delNodes(final TreeNode root, final Set<Integer> nodesToDelete, final List<TreeNode> forestRoots) { 
        if (root == null) return;
        
        final TreeNode leftChild = root.left;
        final TreeNode rightChild = root.right;


        // process left child 
        if (leftChild != null) {

            // add left child as root if not node to be deleted
            if (nodesToDelete.contains(leftChild.val)) { 
                root.left = null;
                
                if (leftChild.left != null && !nodesToDelete.contains(leftChild.left.val))
                    forestRoots.add(leftChild.left);
                
                if (leftChild.right != null && !nodesToDelete.contains(leftChild.right.val))
                    forestRoots.add(leftChild.right);
            } 

            _delNodes(leftChild, nodesToDelete, forestRoots);
        }

        // process right child 
        if (rightChild != null) {

            // add right child as root if not node to be deleted
            if (nodesToDelete.contains(rightChild.val)) {
                root.right = null;
                 if (rightChild.left != null && !nodesToDelete.contains(rightChild.left.val))
                    forestRoots.add(rightChild.left);
                
                if (rightChild.right != null && !nodesToDelete.contains(rightChild.right.val))
                    forestRoots.add(rightChild.right);
            }

            _delNodes(rightChild, nodesToDelete, forestRoots);
        }
    }
}