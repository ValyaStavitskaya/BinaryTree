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
        set.add(20);
        set.add(10);
        set.add(11);
        System.out.println(set);
        Set set2 = new BinaryTree();
        set2.add(8);
        set2.add(9);
        set2.add(10);
        System.out.println(set.retainAll(set2));
        System.out.println(set);










    }
}
