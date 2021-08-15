package hierarchical;

/* https://leetcode.com/problems/inorder-successor-in-bst/ */
public class BSTSuccessor {


    public TreeNode returnSuccessor(TreeNode treeNode) {
        if (treeNode.right != null) {
            return leftMostChildren(treeNode);
        } else {
            TreeNode current = treeNode;
            TreeNode parentOfCurrent = treeNode.parent;

            while(current!=null && current.left != parentOfCurrent) {
                current = parentOfCurrent;
                parentOfCurrent = current.parent;
            }
            return current;
        }
    }

    public TreeNode returnPredecessor(TreeNode treeNode) {
        if (treeNode.left == null) {
            return leftMostChildren(treeNode);
        } else {
            TreeNode current = treeNode;
            TreeNode parentOfCurrent = treeNode.parent;

            while(current!=null && current.right != parentOfCurrent) {
                current = parentOfCurrent;
                parentOfCurrent = current.parent;
            }
            return current;
        }
    }

    private TreeNode leftMostChildren(TreeNode treeNode) {

        if(treeNode ==null) {
            return null;
        }
        if(treeNode.left==null) {
            return treeNode;
        }

        return leftMostChildren(treeNode.left);

    }
}
