import Tree.BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement Serialization to binary Tree
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

            boolean hasAllElements = inBinaryTree == outBinaryTree;

            System.out.println("Contains all elements? " + hasAllElements);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
