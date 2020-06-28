package binaryTree;

import java.util.*;

public class BinaryTree implements Set {

    private Node root;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object o) {
        return containsIn((Integer) o, root);
    }

    private boolean containsIn(int i, Node node) {
        if (node == null)
            return false;
        if (node.data == i) {
            return true;
        } else if (node.data > i)
            return containsIn(i, node.left);
        else
            return containsIn(i, node.right);
    }

    @Override
    public String toString() {
        String result = print(root);
        if (!result.isEmpty())
            result = result.substring(0, result.length() - 2);
        return "[" + result + "]";
    }

    private String print(Node node) {
        String result = "";
        if (node == null)
            return result;
        result += print(node.left);
        result += node.data + ", ";
        result += print(node.right);
        return result;

    }

    @Override
    public Iterator iterator() {
        return new Iterator(root);
    }

    @Override
    public Object[] toArray() {
        Object[] r = new Object[size()];
        Iterator it = iterator();
        for (int i = 0; i < r.length; i++) {
            r[i] = it.next();
        }
        return Arrays.copyOf(r, size());
    }

    @Override
    public boolean add(Object o) {
        Integer data = (Integer) o;
        Node newNode = new Node(data);
        if (root == null)
            root = newNode;
        else
            appendToNode(data, root);
        size++;
        return true;
    }

    private void appendToNode(Integer toAdd, Node node) {
        if (node.data == toAdd)
            return;
        else if (node.data > toAdd) {
            if (node.left == null)
                node.left = new Node(toAdd);
            else
                appendToNode(toAdd, node.left);

        } else {
            if (node.right == null)
                node.right = new Node(toAdd);
            else
                appendToNode(toAdd, node.right);

        }

    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            return false;
        Integer data = (Integer) o;
        removeNode(root, data);
        size--;
        return true;
    }

    private Node removeNode(Node node, Integer toRemove) {
        if (node == null)
            return node;
        if (toRemove > node.data)
            node.right = removeNode(node.right, toRemove);
        else if (toRemove < node.data)
            node.left = removeNode(node.left, toRemove);
        else
            if (node.left != null && node.right != null) {
                node.data = min(node.right).data;
                node.right = removeNode(node.right, node.data);}
            else if (node.left != null)
                node = node.left;
            else if (node.right != null)
                node = node.right;
            else
                node = null;

        return node;
    }

    public Node min(Node node){
         if (node.left == null)
             return node;
         return min(node.left);
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] objects = c.toArray();
        for (Object e : objects)
            add(e);
        return true;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        int count = 0;
        for (int i = 0; i < c.size(); i++) {
            if (contains(c.toArray()[i])) {
                remove(c.toArray()[i]);
                count++;
            }
        }
        if (count > 0)
            return true;
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (containsAll(c)&&c.size()==size())
            return false;
        BinaryTree result = new BinaryTree();
        for (int i = 0; i < c.size(); i++) {
            if (contains(c.toArray()[i]))
                result.add(c.toArray()[i]);
        }
        root = result.root;
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        int count = 0;
        for (int i = 0; i < c.size(); i++) {
            if (contains(c.toArray()[i]))
                count++;
        }
        if (count == c.size())
            return true;
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size())
            return toArray();
        Object[] result = a;
        Iterator it = iterator();
        for (int i = 0; i < result.length; i++)
            result[i] = it.next();
        if (a.length > size)
            a[size] = null;
        return a;

    }


    private class Node {
        Integer data;
        Node left;
        Node right;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private class Iterator implements java.util.Iterator{

        Stack<Node> stack;

        public Iterator(Node root) {
            stack = new Stack<Node>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public Object next() {
            Node node = stack.pop();
            int result = node.data;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return result;
        }
    }


}
