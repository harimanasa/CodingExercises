public class MaxTreePathSum {

    public int maxSum = Integer.MIN_VALUE;

    public int maxContrib(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int maxLeft = this.maxContrib(root.left);
        int maxRight = this.maxContrib(root.right);

        int leftSubtree = 0;
        int rightSubtree = 0;

        if (maxLeft > 0)
            leftSubtree = maxLeft;

        if (maxRight > 0)
            rightSubtree = maxRight;

        int valueNewpath = root.data + leftSubtree + rightSubtree;

        this.maxSum = Math.max(this.maxSum, valueNewpath);

        return root.data + Math.max(leftSubtree, rightSubtree);
    }

    public int maxPathSum(TreeNode<Integer> root) {
        this.maxSum = Integer.MIN_VALUE;
        this.maxContrib(root);
        return this.maxSum;
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree<T> {
    TreeNode<T> root;

    BinaryTree(List<TreeNode<T>> ListOfNodes) {
        root = createBinaryTree(ListOfNodes);
    }

    private TreeNode<T> createBinaryTree(List<TreeNode<T>> ListOfNodes) {
        if (ListOfNodes.isEmpty()) {
            return null;
        }

        // Create the root node of the binary tree
        TreeNode<T> root = new TreeNode<>(ListOfNodes.get(0).data);

        // Create a queue and add the root node to it
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(root);

        // Start iterating over the list of ListOfNodes starting from the second node
        int i = 1;
        while (i < ListOfNodes.size()) {
            // Get the next node from the queue
            TreeNode<T> curr = q.remove();

            // If the node is not null, create a new TreeNode object for its left child,
            // set it as the left child of the current node, and add it to the queue
            if (ListOfNodes.get(i) != null) {
                curr.left = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.left);
            }

            i++;

            // If there are more ListOfNodes in the list and the next node is not null,
            // create a new TreeNode object for its right child, set it as the right child
            // of the current node, and add it to the queue
            if (i < ListOfNodes.size() && ListOfNodes.get(i) != null) {
                curr.right = new TreeNode<>(ListOfNodes.get(i).data);
                q.add(curr.right);
            }

            i++;
        }