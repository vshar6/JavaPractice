package hierarchical;


/* https://leetcode.com/problems/balanced-binary-tree/ */
public class CheckBalancedBST {

    private int getHeight(TreeNode root) {

        if(root==null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    public boolean isBalanced(TreeNode root) {

        if(root==null) {
            return true;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if(heightDiff > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


}
