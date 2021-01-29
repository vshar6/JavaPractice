package hierarchical;

import java.util.LinkedList;

public class RouteBetweenTwoNodes {

    LinkedList<Node> nodes = new LinkedList<>();

    private boolean search(Graph graph, Node start, Node end) {

        for(Node node : graph.getNodes()) {
            node.setNodeState(State.UNVISITED);
        }

        start.setNodeState(State.VISITNG);
        nodes.add(start);
        Node u;
        while(!nodes.isEmpty()) {
            u = nodes.removeFirst();

            if(u!=null) {
                for(Node adjacent :u.getChildren()) {
                    if(!adjacent.getNodeState().equals(State.UNVISITED)) {
                        if(adjacent == end) {
                            return true;
                        } else {
                            adjacent.setNodeState(State.VISITNG);
                        }
                    }
                }
                u.setNodeState(State.VISITED);
            }
        }
        return false;
    }

}
