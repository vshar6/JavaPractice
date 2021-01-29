package hierarchical;

//https://www.educative.io/m/check-if-two-binary-trees-are-identical

public class IdenticalBinaryTrees {

    public static boolean isTreeIdentical(TreeNode t1, TreeNode t2) {

        boolean isIdentical = true;


        if(t1.data!=t2.data) {
            return false;
        }

        isTreeIdentical(t1.left,t2.left);
        isTreeIdentical(t1.right,t2.right);

        return isIdentical;
    }


}
