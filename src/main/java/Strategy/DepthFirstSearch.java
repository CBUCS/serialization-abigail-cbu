package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.*;

public class DepthFirstSearch implements Strategy {

    private List<Object> aList = new ArrayList<Object>();

    public List<Object> Traverse(BinaryTree<Object> binaryTree) {

        DFS(binaryTree);

        return aList;
    }

    public void DFS(BinaryTree<Object> binaryTree) {
        Stack<Node> stack = new Stack<Node>();
        List<Node> visited = new ArrayList<Node>();

        stack.add(binaryTree.root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            aList.add(node.item);

            List<Node> childNodes = new ArrayList<Node>();
            childNodes.add(node.right);
            childNodes.add(node.left);

            for (int i = 0; i < childNodes.size(); i++) {
                Node n = childNodes.get(i);
                if (n != null && !visited.contains(n)) {
                    stack.add(n);
                    visited.add(n);
                }
            }

        }
    }

    public String StrategyName() {
        return "DepthFirstSearch";
    }
}
