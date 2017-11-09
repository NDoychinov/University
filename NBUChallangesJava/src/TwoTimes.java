import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] letters = new int[30];

        String line = reader.readLine();
        while (!line.equals("")) {
            for (int i = 0; i < line.length(); i++) {
                char currChar = line.charAt(i);
                if (currChar >= 97 && currChar <= 122) {
                    letters[currChar - 97] += 1;
                }
            }

            for (int i = 0; i < line.length(); i++) {
                char currChar = line.charAt(i);
                if (currChar >= 97 && currChar <= 122 && letters[currChar - 97] > 1) {
                    System.out.print(line.charAt(i));
                    letters[line.charAt(i) - 97] = 0;
                }
            }
            System.out.println();

            letters = new int[30];
            line = reader.readLine();
        }
    }
}
