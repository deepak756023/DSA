package custom_dynamic_array;

public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(4);
        numbers.insert(10);
        numbers.insert(60);
        numbers.insert(40);
        numbers.insert(20);
        numbers.insertAt(23, 2);
        // numbers.reverse();
        // int max = numbers.max();
        // System.out.println(max);
        numbers.removeAt(1);
        numbers.print();
        int index = numbers.indexOf(140);
        System.out.println(index);

    }
}
