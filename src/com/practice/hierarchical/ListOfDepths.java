package hierarchical;


import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/* Given a binary tree, design an algorithm which creates a LinkedList of all of the nodes of each Depth */
public class ListOfDepths {

    int depth = 0;

    //solution by pre order traversal
    public void createDepthLinkedList(TreeNode treeNode, ArrayList<LinkedList<TreeNode>> lists, int depth) {
        LinkedList<TreeNode> list = null;
        if(list.size()== depth) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list=lists.get(depth);
        }

        list.add(treeNode);

        createDepthLinkedList(treeNode.left, lists, depth+1);
        createDepthLinkedList(treeNode.right, lists, depth+1);
    }

    //solution by BFS
    public ArrayList<LinkedList<TreeNode>> createDepthLinkedList(TreeNode treeNode) {

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();

        if(treeNode==null) {
            return null;
        } else {
            list.add(treeNode);
        }

        while(list.size() > 0) {
            lists.add(list);

            LinkedList<TreeNode> parents = list;
            for(TreeNode parent: parents) {
                if(parent.left!=null) {
                    list.add(parent.left);
                }

                if(parent.right!=null) {
                    list.add(parent.right);
                }
            }
        }

        return lists;
    }

}
