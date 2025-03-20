package ReverseEverySecondLetter;

import java.util.stream.IntStream;

// Вывести строку в обратном порядке, каждую вторую букву
class ReverseEverySecondLetter {

    public static void main(String[] args) {
        String s = "Spring Boot!";

        char[] chars  = s.toCharArray();
        StringBuilder output = new StringBuilder();

        IntStream.range(0, s.length())
                 .forEach((i) -> {
                    if (i % 2 == 0) {
                        char temp = chars[i];
                        chars[i] = chars[i+1];
                        chars[i+1] = temp;
                    }
                    output.append(chars[i]);
                 });
        
        System.out.println(output.toString());
    }
}
