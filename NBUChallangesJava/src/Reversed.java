import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reversed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        if (line.equalsIgnoreCase("array")) {
            String[] numbers = reader.readLine().split("\\s");

            for (int i = numbers.length - 1; i >= 0 ; i--) {
                System.out.print(numbers[i] + " ");
            }

        } else {
            String word = reader.readLine();
            for (int i = word.length() - 1; i >= 0; i--) {
                System.out.print(word.charAt(i));
            }
        }
    }
}
