package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the height of the tree (longest branch)
 */
public class MaxDepth implements Strategy {

    private List<Object> aList = new ArrayList<Object>();

    public List<Object> Traverse(BinaryTree<Object> binaryTree) {

        if (binaryTree != null && binaryTree.root != null) {

            aList.add(maxDepth(binaryTree.root)); // returns 1 value == max depth
            return aList;
        }

        return null;
    }

    public int maxDepth(Node node) {
        if (node != null) {

            // compute the depth of each subtree
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            // use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
        else
        {
            return 0;
        }
    }

    public String StrategyName(){
        return "MaxDepth";
    }

}
