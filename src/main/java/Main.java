import Tree.BinaryTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement Serialization to binary Tree
 */

public class Main {

    public static void main(String args[]) {

        BinaryTree<Object> binaryTree = new BinaryTree<Object>();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);

        String filename = "binaryTree.ser";

        // Serialization
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(binaryTree);
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
            BinaryTree outBinaryTree = (BinaryTree) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("Deserialized data from binaryTree.ser");
            boolean hasAllElements = true;
            for (int i = 1; i <= outBinaryTree.size(); i++) {
                if (outBinaryTree.contains(i) != (Object) i) {
                    hasAllElements = false;
                    break;
                }
            }

            System.out.println("Contains all elements? " + hasAllElements);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
