package binary_tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(12);
        tree.insert(11);
        tree.insert(15);

        System.out.println(tree.find(8));
        System.out.println(tree.find(15));
        System.out.println(tree.find(20));
        System.out.println(tree.find(4));

    }

}
