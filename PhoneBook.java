import java.util.*;

public class PhoneBook {
    //Реализуйте структуру телефонной книги с помощью HashMap.
    //Программа также должна учитывать, что во входной
    // структуре будут повторяющиеся имена с разными телефонами, их необходимо считать,
    // как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 123124124, bookPhone);
        addNumber("Ivanov", 123463241, bookPhone);
        addNumber("Petrov", 546581235, bookPhone);
        addNumber("Sidorov", 895612477, bookPhone);
        addNumber("Ivanov", 1235626733, bookPhone);
        addNumber("Petrov", 787237897, bookPhone);
        printBook(bookPhone);
    }

    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public static void printBook(Map<String, ArrayList<Integer>> map) {

        List<Map.Entry<String, ArrayList<Integer>>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, Comparator.comparingInt(entry -> entry.getValue().size()));

        for(Map.Entry<String, ArrayList<Integer>> entry : sortedList) {
            String phones = " ";
            for(int el : entry.getValue()) {
                phones += el + " ";
            }
            System.out.printf("%s: %s\n", entry.getKey(), phones);
        }
    }

}
