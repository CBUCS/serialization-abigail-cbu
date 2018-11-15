package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Call itself to traverse the node's left subtree.
 * 2. Call itself to traverse the node's right subtree.
 * 3. Visit the node.
 */
public class PostOrder implements Strategy {

    private List<Object> aList = new ArrayList<Object>();

    public List<Object> Traverse(BinaryTree<Object> binaryTree) {

        if (binaryTree != null && binaryTree.root != null) {

            postOrder(binaryTree.root);
            return aList;
        }

        return null;
    }

    public void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        aList.add(node.item);
    }

    public String StrategyName(){
        return "PostOrder";
    }
}
