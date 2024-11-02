package hierarchical;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphTraversals {
//    public void breadthFirst(Node root) {
//        Queue<Node> queue = new PriorityQueue<>();
//
//        queue.add(root);
//        root.setNodeState(State.VISITED);
//        while (!queue.isEmpty()) {
//            Node temp = queue.peek();
//            for(Node n : temp.children) {
//                if(!n.getNodeState().equals(State.VISITED)) {
//                    n.setNodeState(State.VISITED);
//                    queue.add(n);
//                }
//            }
//        }
//    }

//    public void depthFirst(Node root) {
//        if(root == null) {
//            return;
//        } else {
//            root.setNodeState(State.VISITED);
//            for(Node children : root.getChildren()) {
//                if(!children.getNodeState().equals(State.VISITED)) {
//                    depthFirst(children);
//                }
//            }
//        }
//    }


    public void depthFirstTraversal(Node root) {
        if(root == null) {
            return;
        } else {
            root.setNodeState(State.VISITED);
            for(Node child : root.children) {
                child.setNodeState(State.VISITED);
                depthFirstTraversal(child);
            }
        }
    }

    public void breadthFirstTraversal(Node root) {
        Queue<Node> queue = new PriorityQueue();
        queue.add(root);
        root.setNodeState(State.VISITED);
        while(!queue.isEmpty()) {
            Node rootNode = queue.peek();
            for(Node child: rootNode.children) {
                if(child.nodeState!=State.UNVISITED) {
                    child.nodeState = State.VISITED;
                    queue.add(child);
                }
            }
        }
    }
}
