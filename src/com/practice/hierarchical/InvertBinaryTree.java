package hierarchical;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root==null) {
            return root;
        } else {
            TreeNode temp = root.right;
            root.right=root.left;
            root.left = temp;

            invertTree(root.right);
            invertTree(root.left);
        }



        return root;

    }

}
