package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;


/**
 * 1. Visit the node.
 * 2. Call itself to traverse the node's left subtree.
 * 3. Call itself to traverse the node's right subtree.
 */
public class PreOrder implements Strategy {

    private List<Object> aList = new ArrayList<Object>();

    public List<Object> Traverse(BinaryTree<Object> binaryTree) {

        if (binaryTree != null && binaryTree.root != null) {

            preOrder(binaryTree.root);
            return aList;
        }

        return null;
    }

    public void preOrder(Node node) {
        if (node == null)
            return;

        aList.add(node.item);
        preOrder(node.left);
        preOrder(node.right);
    }

    public String StrategyName(){
        return "PreOrder";
    }

}
