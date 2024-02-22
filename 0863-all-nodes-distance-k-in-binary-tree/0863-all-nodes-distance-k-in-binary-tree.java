/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class NodeLevel {
        TreeNode node;
        int level;
        
        NodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    public List<Integer> distanceKBelow(TreeNode root, int k) {
        final Queue<NodeLevel> queue = new LinkedList<>();
        final List<Integer> resultNodes = new ArrayList<>();
        queue.offer(new NodeLevel(root, 0));
        
        while (!queue.isEmpty()){
            final NodeLevel currNodeLevel = queue.poll();
            final int currentLevel = currNodeLevel.level;
            final TreeNode currentNode = currNodeLevel.node;
            if (currentLevel == k) resultNodes.add(currentNode.val);
            else {
                if (currentNode.left != null) queue.offer(new NodeLevel(currentNode.left, currentLevel + 1));
                if (currentNode.right != null) queue.offer(new NodeLevel(currentNode.right, currentLevel + 1));
            }
        }
        
        return resultNodes;
    }
    
    public void fillParentTillTarget(TreeNode[] parent, TreeNode root, TreeNode target) {
        if (root == target) return;
        
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            final TreeNode currNode = queue.poll();
            
            if (currNode == target) return;
            
            if (currNode.left != null) {
                queue.offer(currNode.left);
                parent[currNode.left.val] = currNode;
            }
            
            if (currNode.right != null) {
                queue.offer(currNode.right);
                parent[currNode.right.val] = currNode;
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        final TreeNode[] parent = new TreeNode[500];
        
        fillParentTillTarget(parent, root, target);
        
        final List<Integer> distanceNodes = new ArrayList<>();
        TreeNode currRootNode = target;
        while (true) {
            distanceNodes.addAll(distanceKBelow(currRootNode, k));
            final TreeNode parentNode = parent[currRootNode.val];
            if (parentNode == null) return distanceNodes;
            if (parentNode.left == currRootNode) parentNode.left = null;
            else parentNode.right = null;
            currRootNode = parentNode;
            k--;
        }
    }
}