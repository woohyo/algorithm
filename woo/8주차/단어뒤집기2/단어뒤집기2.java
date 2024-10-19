import java.util.Scanner;
import java.util.stream.Stream;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean insideTag = false;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);

            if (c == '<') {
                if (word.length() > 0) {
                    result.append(word.reverse());
                    word.setLength(0);
                }
                insideTag = true;
                result.append(c);
            } else if (c == '>') {
                insideTag = false;
                result.append(c);
            } else if (insideTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    result.append(word.reverse());
                    result.append(c);
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }

        if (word.length() > 0) {
            result.append(word.reverse());
        }

        System.out.println(result.toString());
    }
}
