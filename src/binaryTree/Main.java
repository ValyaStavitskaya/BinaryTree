package binaryTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set set = new BinaryTree();
        set.add(8);
        set.add(3);
        set.add(4);
        set.add(9);
        set.add(5);
        System.out.println(set);
        System.out.println(Arrays.toString(set.toArray()));
        Set set2 = new BinaryTree();
        set2.add(8);
        set2.add(9);
        set2.add(0);
        System.out.println(set.containsAll(set2));










    }
}
