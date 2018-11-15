import Strategy.*;
import Tree.BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Take your binary tree and serialize the object.
 * Then read it from disk and verify it is the same as your original input.
 */

public class Main {

    public static void main(String args[]) {

        BinaryTree<Object> inBinaryTree = new BinaryTree<Object>();
        inBinaryTree.add(1);
        inBinaryTree.add(2);
        inBinaryTree.add(3);
        inBinaryTree.add(4);
        inBinaryTree.add(5);

        String filename = "binaryTree.ser";

        List<Strategy> strategies = new ArrayList<Strategy>();
        // Add strategies here.
        strategies.add(new BreadthFirstSearch());

        // Serialization
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(inBinaryTree);
            os.close();
            fos.close();

            System.out.println("Serialized data is saved in binaryTree.ser");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        //Deserialize
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            BinaryTree<Object> outBinaryTree = (BinaryTree) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("Deserialized data from binaryTree.ser");

            List<Object> inList = strategies.get(0).Traverse(inBinaryTree);
            List<Object> outList = strategies.get(0).Traverse(outBinaryTree);
            boolean hasAllElements = inList == outList;

            System.out.println("Contains all elements? " + hasAllElements);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
