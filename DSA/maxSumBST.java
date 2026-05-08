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
    int maxSum = 0;

    class Info{
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST , int min , int max , int sum){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private Info solve(TreeNode node){
        if(node == null){
            return new Info(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }

        Info left = solve(node.left);
        Info right = solve(node.right);

        if(left.isBST && right.isBST && node.val > left.max && node.val < right.min){
            int currSum = left.sum + right.sum + node.val;

            maxSum = Math.max(maxSum , currSum);

            return new Info(true , Math.min(node.val , left.min) , Math.max(node.val , right.max) , currSum);
        }
        return new Info(false , 0 , 0, 0);
        
    }

    
}