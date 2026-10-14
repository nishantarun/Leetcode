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
    public long kthLargestLevelSum(TreeNode root, int k) {
        long res = -1;
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Long> list = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            long levelSum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                levelSum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            list.add(levelSum);
        }
        Collections.sort(list);
        int kth = list.size() - k;
        if(kth >= 0) return list.get(kth);
        else return -1;
    }
}