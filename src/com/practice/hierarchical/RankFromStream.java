package hierarchical;



import java.util.ArrayList;
import java.util.List;

public class RankFromStream {

    TreeNode root = null;


    public void track(int input) {
        if(root == null) {
            root = new TreeNode(input);
        } else {
            root.insert(input);
        }
    }

    public int getRank(int input) {
        return root.getRank(input);
    }

}
