package Tree;

import java.io.Serializable;
import java.util.LinkedList;

public class BinaryTree<T> implements Serializable {

    public Node<T> root;
    private int size = 0;

    public BinaryTree() {
        root = null;
    }

    public void add(T item) {
        if (this.root == null) {
            this.root = new Node<T>(item);
        } else {
            insert(this.root, item);
        }

        this.size++;
    }

    public Node<T> insert(Node<T> bNode, T item) {
        if (bNode == null) {
            bNode = new Node<T>(item);
        } else {
            if (bNode.getRight() == null) {
                bNode.right = insert(bNode.right, item);
            } else {
                bNode.left = insert(bNode.left, item);
            }
        }

        return bNode;
    }

    public Node<T> contains(T item) {
        return search(root, item);
    }

    public Node<T> search(Node<T> bNode, T item) {
        if (bNode == null) {
            return null;
        } else {
            Node<T> tempNode;
            if (bNode.item == item) {
                return bNode;
            } else {
                // check left node
                tempNode = bNode.left;
                if (search(tempNode, item) != null) {
                    return tempNode;
                }

                // check right node if left node didn't return anything
                tempNode = bNode.right;
                if (search(tempNode, item) != null) {
                    return tempNode;
                }

                // else, we didn't find anything
                return null;

            }
        }
    }

    public int size() {
        return this.size;
    }

}
