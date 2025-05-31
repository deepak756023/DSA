package hash_table;

public class Main {
    public static void main(String[] args) {

        // FindChar findChar = new FindChar();
        // var result1 = findChar.findFirstNonRepeatChar("my name is deepak nayak");
        // System.out.println(result1);

        // var result2 = findChar.findFirstRepeatChar("my name is deepak nayak");
        // System.out.println(result2);

        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A+");
        table.remove(11);
        System.out.println(table.get(6));

    }
}
