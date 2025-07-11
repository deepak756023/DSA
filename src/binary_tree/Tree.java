package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int item) {
        var node = new Node(item);
        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (item < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;

            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;

            }

        }
    }

    public boolean find(int item) {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        while (current != null) {
            if (item == current.value) {
                return true;
            } else {
                if (item < current.value) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
            }

        }
        return false;
    }

    public void depthPreOrder() {
        depthPreOrder(root);
    }

    private void depthPreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        depthPreOrder(root.leftChild);
        depthPreOrder(root.rightChild);
    }

    public void depthInOrder() {
        depthInOrder(root);
    }

    private void depthInOrder(Node root) {
        if (root == null)
            return;
        depthInOrder(root.leftChild);
        System.out.println(root.value);
        depthInOrder(root.rightChild);
    }

    public void depthPostOrder() {
        depthPostOrder(root);
    }

    private void depthPostOrder(Node root) {
        if (root == null)
            return;
        depthPostOrder(root.leftChild);
        depthPostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));

    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {

        if (root == null)
            return Integer.MAX_VALUE;

        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);

    }

    public boolean equals(Tree tree) {
        return equals(root, tree.root);
    }

    private boolean equals(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 != null && root2 != null) {
            return root1.value == root2.value
                    && equals(root1.leftChild, root2.leftChild)
                    && equals(root1.rightChild, root2.rightChild);
        }
        return false;
    }

    public void swap() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++)
            for (var item : getNodesAtDistance(i))
                System.out.println(item);

    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;

        return (size(root.leftChild) + size(root.rightChild)) + 1;

    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        return max(root);
    }

    // postOrder
    private int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (isLeaf(root)) {
            return root.value;
        }

        var left = max(root.leftChild);
        var right = max(root.rightChild);
        return Math.max(Math.max(left, right), root.value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    // preOrder
    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(root, value1, value2);

    }

    public boolean areSiblings(Node root, int a, int b) {
        if (root == null)
            return false;

        if (root.leftChild != null && root.rightChild != null) {
            int leftVal = root.leftChild.value;
            int rightVal = root.rightChild.value;

            if ((leftVal == a && rightVal == b) || (leftVal == b && rightVal == a))
                return true;
        }

        // Recursively check in left and right subtree
        return areSiblings(root.leftChild, a, b) || areSiblings(root.rightChild, a, b);
    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list) ||
                getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        var balanceFactor = height(root.leftChild) - height(root.rightChild);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(root.leftChild) &&
                isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }
}
