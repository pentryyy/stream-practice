package UniqueString;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// Найти уникальные строки в строке
public class UniqueString {

    public static void main(String[] args) {
        String s = "Строка строка представляет собой последовательность символов символов." + 
                  " Для работы со строками в 'Java' определен класс <String>, который представляет " + 
                  "ряд методов для манипуляции строками.";
    
        Set<String> uniqueStrings = new HashSet<>();
        String[]    strings       = s.split("\\s+");

        IntStream.range(0, strings.length)
                 .forEach(i -> uniqueStrings.add(strings[i]));

        System.out.println(uniqueStrings);
    }
}
