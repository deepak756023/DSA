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
        if (root == null)
            root = node;
        else {
            var current = root;
            while (current != null) {
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

}
