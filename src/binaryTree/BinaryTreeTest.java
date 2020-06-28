package binaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    public void setUp(){
        binaryTree = new BinaryTree();
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(9);
        binaryTree.add(2);
    }

    @Test
    public void testAddAndSize(){
        Assertions.assertEquals(5,binaryTree.size());
    }

    @Test
    public void testRemoveAndSize(){
        binaryTree.remove(4);
        Assertions.assertEquals(4, binaryTree.size());
    }

    @Test
    public void testContains(){
        Assertions.assertTrue(binaryTree.contains(8));
        binaryTree.remove(4);
        Assertions.assertFalse(binaryTree.contains(20));
        Assertions.assertFalse(binaryTree.contains(4));
    }

    @Test
    public void testIsEmptyAndClear(){
        binaryTree.clear();
        Assertions.assertTrue(binaryTree.isEmpty());
        binaryTree.add(7);
        Assertions.assertFalse(binaryTree.isEmpty());
    }



}