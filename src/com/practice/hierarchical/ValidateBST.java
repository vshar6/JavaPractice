package hierarchical;

public class ValidateBST {

    public void copyBST(TreeNode node, int[] array, int index) {

        if(node==null) {
            return;
        }
        array[index]=node.data;
        copyBST(node.left, array, index++);
        copyBST(node.right, array, index++);

    }

    public boolean checkBST(TreeNode root, int [] array) {

        copyBST(root, array,0);
        for(int index = 1 ; index < array.length;index++) {
            if(array[index-1] >= array[index]) {
                return false;
            }
        }

        return true;
    }
}
