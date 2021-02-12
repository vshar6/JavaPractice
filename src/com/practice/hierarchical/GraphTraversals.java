package hierarchical;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphTraversals {
    public void breadthFirst(Node root) {
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            root.setNodeState(State.VISITED);

            for(Node n : temp.children) {
                if(!n.getNodeState().equals(State.VISITED)) {
                    n.setNodeState(State.VISITED);
                    queue.add(n);
                }
            }
        }
    }

    public void depthFirst(Node root) {
        if(root == null) {
            return;
        } else {
            root.setNodeState(State.VISITED);
            for(Node children : root.getChildren()) {
                if(!children.getNodeState().equals(State.VISITED)) {
                    depthFirst(children);
                }
            }
        }
    }
}
