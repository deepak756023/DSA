package binary_tree;

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

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));

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

}
