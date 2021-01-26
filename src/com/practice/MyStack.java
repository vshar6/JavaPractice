

import org.w3c.dom.Node;

public class MyStack<T> {

    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T item) {
            this.data=item;
        }

    }

    private StackNode<T> top;
    private T min;

    public void push(T item) {
        StackNode<T> node = new StackNode<>(item);
        min = top.data;
        node.next = top;
        top = node;


    }

    public T pop() {
        T item = peek();
        return item;
    }

    public T peek() {
        if(top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T min() {
        return min;
    }

}
