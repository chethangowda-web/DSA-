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

    public int rob(TreeNode root) {

        int[] result = solve(root);

        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        // Don't rob current node
        int notRob =
                Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        // Rob current node
        int rob =
                node.val
                + left[0]
                + right[0];

        return new int[]{notRob, rob};
    }
}