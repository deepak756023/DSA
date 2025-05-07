package linked_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        // list.removeLast();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(20));

    }

}
