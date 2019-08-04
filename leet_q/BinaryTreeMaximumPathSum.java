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
    private int max = Integer.MIN_VALUE;
    public int _maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int rightChildValue = _maxPathSum(root.right);
            int leftChildValue = _maxPathSum(root.left);
            int nodeValue = root.val + (rightChildValue > 0 ? rightChildValue : 0) + (leftChildValue > 0 ? leftChildValue : 0);
            this.max = Math.max(this.max, nodeValue);
            return root.val + Math.max(rightChildValue > 0 ? rightChildValue : 0, leftChildValue > 0 ? leftChildValue : 0);
        }
    }

    public int maxPathSum(TreeNode root) {
        _maxPathSum(root);
        return this.max;
    }
}