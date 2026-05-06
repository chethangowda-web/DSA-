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
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
       inorder(root , k);
       return result;
    }
    private void inorder(TreeNode node , int k){
        if(node == null) return;

        inorder(node.left , k);
        count++;

        if(count == k){
            result = node.val;
            return;
        }

        inorder(node.right , k);
    }  
    }