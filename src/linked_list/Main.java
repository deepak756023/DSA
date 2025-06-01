package linked_list;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(40);
        System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(list.findKthNodeFromTheEnd(6));
        list.findMiddle();

        // list.removeLast();
        // System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(list.contains(10));
        // System.out.println(list.indexOf(20));
        // list.reverse();
        // System.out.println(Arrays.toString(list.toArray()));

    }

}
