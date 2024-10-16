/* https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/ */
package hierarchical;

import java.util.LinkedList;
import java.util.List;

public class SubTreeOfATree {


    public static List<Integer> postOrder(TreeNode tree) {
        List<Integer> bigTreeList = new LinkedList<>();

        final TreeNode current = tree.parent;
        if(current != null) {
            postOrder(current.left);
            postOrder(current.right);
            visit(current,bigTreeList);
        }

        return bigTreeList;
    }

    private static void visit(TreeNode treeNode, List<Integer> bigTreeList) {
        System.out.println(treeNode.data);
        bigTreeList.add(treeNode.data);
        //return treeNode.data;
    }

    private static boolean checkifSubTreeByArrayComparison(List<Integer> bigTreeList, List<Integer> subTreeList) {
        for(int index = 0;index < bigTreeList.size();index++) {
            List<?> subList = bigTreeList.subList(index,subTreeList.size());
            boolean isSubTree = subList.equals(subTreeList);
            if(isSubTree) {
                return isSubTree;
            }
        }
        return false;
    }


    private static boolean checkIfSubtreeByRootComparison(TreeNode treeNode, TreeNode subTree) {

        if(treeNode.data != subTree.data) {
            return false;
        }
        if(!checkIfIdentical(treeNode,subTree)) {
            return checkIfSubtreeByRootComparison(treeNode.left, subTree) || checkIfSubtreeByRootComparison(treeNode.right, subTree);
        } else {
            return true;
        }
    }


    private static boolean checkIfIdentical(TreeNode treeNode, TreeNode subTree) {

        boolean isIdentical = true;

        if (treeNode.data == subTree.data) {
            checkIfIdentical(treeNode.left, subTree.left);
            checkIfIdentical(treeNode.right, subTree.right);
        } else {
            return false;
        }
        return isIdentical;
    }


    public static void main(String [] args) {
       // Construct Tree root1
        //          26
        //         /  \
        //        10   3
        //       / \    \
        //      4   6    3
        //       \
        //        30
        TreeNode bigTree = new TreeNode(26);
        bigTree.right = new TreeNode(3);
        bigTree.right.right = new TreeNode(3);
        bigTree.left = new TreeNode(10);
        bigTree.left.left = new TreeNode(4);
        bigTree.left.left.right = new TreeNode(30);
        bigTree.left.right = new TreeNode(6);

        // Construct Tree root2
        //          10
        //         /  \
        //        4    6
        //         \
        //          30
        TreeNode subTree = new TreeNode(10);
        subTree.right = new TreeNode(6);
        subTree.left = new TreeNode(4);
        subTree.left.right = new TreeNode(30);
        checkifSubTreeByArrayComparison(postOrder(bigTree),postOrder(subTree)); //Approach 1
        checkIfSubtreeByRootComparison(bigTree, subTree);
    }

}
