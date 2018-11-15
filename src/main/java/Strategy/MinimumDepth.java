package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class MinimumDepth implements Strategy {

    private List<Object> aList = new ArrayList<Object>();

    public List<Object> Traverse(BinaryTree<Object> binaryTree) {

        if (binaryTree != null && binaryTree.root != null) {

            aList.add(minDepth(binaryTree.root)); // returns 1 value == max depth
            return aList;
        }

        return null;
    }

    public int minDepth(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left == null) {
            return minDepth(node.right) + 1;
        }

        if (node.right == null) {
            return minDepth(node.left) + 1;
        }

        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }

    public String StrategyName(){
        return "MinimumDepth";
    }
}
