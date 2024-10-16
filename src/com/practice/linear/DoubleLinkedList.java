package linear;



public class DoubleLinkedList {

    private LinearNode head;
    private LinearNode tail;

    public LinearNode getHead() {
        return head;
    }

    public void setHead(LinearNode head) {
        this.head = head;
    }

    public LinearNode getTail() {
        return tail;
    }

    public void setTail(LinearNode tail) {
        this.tail = tail;
    }

    public DoubleLinkedList(LinearNode value) {
        this.head = value;
    }

}
