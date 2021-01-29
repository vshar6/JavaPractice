package hierarchical;

public class Node {

    public String name;
    public Node[] children;

    public State nodeState;

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public State getNodeState() {
        return nodeState;
    }

    public void setNodeState(State nodeState) {
        this.nodeState = nodeState;
    }
}

 enum State {
    UNVISITED,
    VISITED,
    VISITNG;
}