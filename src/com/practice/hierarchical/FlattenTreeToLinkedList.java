package hierarchical;

import java.util.LinkedList;


    /* https://leetcode.com/problems/flatten-binary- tree-to-linked-list/ */

public class FlattenTreeToLinkedList {

    LinkedList<TreeNode> list = new LinkedList<>();

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        if(root.left != null){
            if(root.right !=null){
                TreeNode temp = root.left;
                while(temp.right != null){
                    temp= temp.right;
                }
                temp.right = root.right;
            }
            root.right = root.left;
            root.left = null;
        }
    }

}
