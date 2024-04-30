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
    public TreeNode recursive_invertTree_DFS(TreeNode root) {
        //recursive Time: O(N), and Space: O(N), DFS

        //base case
        if(root == null) return root;
        
        recursive_invertTree_DFS(root.left);
        recursive_invertTree_DFS(root.right);

        /** swap */
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

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

    public TreeNode invertTree(TreeNode root) {
        return iterative_invertTree_BFS(root);
    }
}