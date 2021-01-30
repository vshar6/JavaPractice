package hierarchical;

public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }



    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data=data;
        this.left = left;
        this.right = right;
    }

}
