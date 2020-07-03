package binaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;
    private Set set;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(9);
        binaryTree.add(2);
        set = new TreeSet();
        set.add(4);
        set.add(8);
        set.add(3);
        set.add(9);
        set.add(2);
    }

    @Test
    public void testAddAndSize() {
        Assertions.assertEquals(5, binaryTree.size());
        Assertions.assertEquals(set, binaryTree);
    }

    @Test
    public void testRemoveAndSize() {
        binaryTree.remove(4);
        set.remove(4);
        Assertions.assertEquals(4, binaryTree.size());
        Assertions.assertEquals(set, binaryTree);
    }

    @Test
    public void testContains() {
        Assertions.assertTrue(binaryTree.contains(8));
        binaryTree.remove(4);
        Assertions.assertFalse(binaryTree.contains(20));
        Assertions.assertFalse(binaryTree.contains(4));
    }

    @Test
    public void testIsEmptyAndClear() {
        binaryTree.clear();
        Assertions.assertTrue(binaryTree.isEmpty());
        binaryTree.add(7);
        Assertions.assertFalse(binaryTree.isEmpty());
    }

    @Test
    void testAddAll() {
        Set tree = new TreeSet();
        tree.add(6);
        tree.add(7);
        tree.add(11);
        binaryTree.addAll(tree);
        set.add(6);
        set.add(7);
        set.add(11);
        Assertions.assertEquals(set, binaryTree);

    }

    @Test
    void testRemoveAll() {
        Set tree = new TreeSet();
        tree.add(2);
        tree.add(8);
        tree.add(11);
        Assertions.assertTrue(binaryTree.removeAll(tree));
        set.remove(2);
        set.remove(8);
        Assertions.assertEquals(set,binaryTree);
        Set tree2 = new TreeSet();
        tree2.add(15);
        tree2.add(20);
        Assertions.assertFalse(binaryTree.removeAll(tree2));

    }

    @Test
    void testRetainAll() {
        Set tree = new TreeSet();
        tree.add(8);
        tree.add(2);
        tree.add(11);
        Assertions.assertTrue(binaryTree.retainAll(tree));
    }

    @Test
    void testContainsAll() {
        Assertions.assertTrue(binaryTree.containsAll(set));
        Set tree = new TreeSet();
        tree.add(20);
        tree.add(21);
        tree.add(24);
        Assertions.assertFalse(binaryTree.containsAll(tree));
    }

}