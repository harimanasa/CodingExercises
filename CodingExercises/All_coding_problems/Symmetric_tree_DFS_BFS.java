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

/** Reference: BFS */

   public TreeNode iterative_invertTree_BFS(TreeNode root) {
        //iterative Time: O(N), and Space: O(N), DFS

        //base case
        if(root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //swap and add
            TreeNode curr = queue.poll();

            /** swap */
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
        }
        return root;
    }