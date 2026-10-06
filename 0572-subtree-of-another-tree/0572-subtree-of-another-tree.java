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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return helper(root, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        
        if(isSameTree(root, subRoot)) return true;

        boolean left = helper(root.left, subRoot);
        boolean right = helper(root.right, subRoot);

        return left || right;
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;

        boolean left = isSameTree(node1.left, node2.left);
        boolean right = isSameTree(node1.right, node2.right);

        return left && right;
    }
}