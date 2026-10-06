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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }

    public int diameter(TreeNode node) {
        if(node == null) return 0;

        int leftDiameter = diameter(node.left);
        int rightDiameter = diameter(node.right);
        int currDiameter = maxDepth(node.left) + maxDepth(node.right);

        return Math.max(currDiameter, Math.max(leftDiameter, rightDiameter)); 
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0 ;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}