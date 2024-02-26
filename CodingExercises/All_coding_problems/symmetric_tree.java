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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null) return true; //leaf nodes
        if(left == null || right == null) return false; //one leaf but one non-leaf

        //both non-leaves and R==L && R.L == L.R && R.R == L.L
        return left.val==right.val && isMirror(left.right, right.left) 
        && isMirror(left.left, right.right);
    }
}