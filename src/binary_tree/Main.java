package binary_tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(6);
        tree.insert(14);
        tree.insert(24);
        tree.insert(3);
        tree.insert(8);
        tree.insert(26);
        tree.insert(100);

        // var list = tree.getNodesAtDistance(3);
        // for (var item : list)
        // System.out.println(item);

        // tree.traverseLevelOrder();
        System.out.println(tree.size());

        System.out.println(tree.countLeaves());

        System.out.println(tree.max());

        // tree.swap();

        // System.out.println(tree.isBinarySearchTree());

        // tree.depthPostOrder();

        // System.out.println(tree.height());
        // Tree newTree = new Tree();
        // newTree.insert(20);
        // newTree.insert(10);
        // newTree.insert(30);
        // newTree.insert(6);
        // newTree.insert(14);
        // newTree.insert(24);
        // newTree.insert(3);
        // newTree.insert(8);
        // newTree.insert(26);

        // System.out.println(tree.equals(newTree));

    }

}
