package hierarchical;

public class BinaryTreeOperations {


    public void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            visit(tree);
            inOrder(tree.right);
        }
    }

    public void preOrder(TreeNode tree) {
        if (tree != null) {
            visit(tree);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void postOrder(TreeNode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            visit(tree);
        }
    }

    private int visit(TreeNode treeNode) {
        return treeNode.data;
    }



}
