import Tree.BinaryTree;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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


        try
        {
            FileOutputStream fos = new FileOutputStream("binaryTree.ser");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(binaryTree);
            os.close();
            fos.close();

            System.out.println("Serialized data is saved in /binaryTree.ser");

            
        }
        catch(IOException ex){
            System.out.println(ex.getLocalizedMessage());
        }

    }
}
