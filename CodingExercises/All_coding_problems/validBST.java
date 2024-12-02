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
 * 
 * O(n) Time, O(n) Space
 */
class Solution {
    Integer pastElement = null;
    public boolean isValidBST(TreeNode root) {
     if(root.left!=null){
            if(isValidBST(root.left)==false) return false;
        }
        
        //process root
        if(pastElement!=null && pastElement>=root.val) return false;
        else{
            pastElement = root.val;
            //System.out.println(root.val);
        }
        if(root.right!=null){
            if(isValidBST(root.right)==false) return false;
        } 
        return true;
    }
}