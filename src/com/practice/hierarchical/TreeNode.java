package hierarchical;

public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int rank = 0;

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

    public void insert(int input) {
        if(data > input) {
            if(left != null) {
                left.insert(data);
            } else {
                left = new TreeNode(data);
            }
        } else {
            if(right != null) {
                right.insert(data);
            } else {
                right = new TreeNode(data);
            }
        }
    }

    public int getRank(int input) {

        if (data == input) { //base case
            return rank;
        } else {
            if (data > input) {
                if (left == null) {
                    return -1;
                } else {
                    return left.getRank(input);
                }
            } else {
                int rightRank = right == null ? -1 : right.getRank(input);
                if (rightRank == -1) {
                    return -1;
                } else {
                    return rank + rightRank + 1;
                }
            }
        }
    }

}
