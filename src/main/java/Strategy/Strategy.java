package Strategy;

import Tree.BinaryTree;
import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public interface Strategy {

    String StrategyName();

    List<Object> Traverse(BinaryTree<Object> binaryTree);
}
