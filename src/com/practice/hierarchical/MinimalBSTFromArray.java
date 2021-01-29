package hierarchical;


/* Given a sorted (increasing order) array with unique integers elements, write an algo to create a BST with minimal height */


public class MinimalBSTFromArray {

    public TreeNode createMinimalBST(int [] array) {
        return createMinimalBST(array,0,array.length-1);
    }

    private TreeNode createMinimalBST(int[] array, int start, int end) {

        if(end < start) {
            return null;
        }

        int mid = (start + end)/2;

        TreeNode treeNode = new TreeNode(array[mid]);

        treeNode.left = createMinimalBST(array,start, mid-1);
        treeNode.right = createMinimalBST(array, mid+1,end);

        return treeNode;
    }
}
