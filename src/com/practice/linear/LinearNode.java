package linear;

public class LinearNode {
    private int data;
    private LinearNode previous;
    private LinearNode next;



    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinearNode getPrevious() {
        return previous;
    }

    public void setPrevious(LinearNode previous) {
        this.previous = previous;
    }

    public LinearNode getNext() {
        return next;
    }

    public void setNext(LinearNode next) {
        this.next = next;
    }

    public LinearNode(int value) {
        this.data = value;
        this.previous=null;
        this.next = null;
    }

    public LinearNode(int value, LinearNode previous, LinearNode next) {
        this.data = value;
        this.previous=previous;
        this.next = next;
    }
}
