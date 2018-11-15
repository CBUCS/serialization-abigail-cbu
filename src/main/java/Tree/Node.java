package Tree;

import java.io.Serializable;

public class Node<T> implements Serializable {

    public T item;
    public Node<T> right;
    public Node<T> left;

    public Node() {
        this.item = null;
        this.right = null;
        this.left = null;
    }

    public Node(T newItem) {
        this.item = newItem;
        this.right = null;
        this.left = null;
    }

    public void setItem(T newItem) {
        this.item = newItem;
    }

    public void setRight(Node<T> newRightNode) {
        this.right = newRightNode;
    }

    public void setLeft(Node<T> newLeftNode) {
        this.left = newLeftNode;
    }

    public T getItem() {
        return this.item;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public Node<T> getLeft() {
        return this.left;
    }
}
