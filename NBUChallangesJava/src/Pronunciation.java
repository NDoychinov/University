import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pronunciation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            int vowels = 0;
            int consonant = 0;
            String word = reader.readLine();
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                if (currentChar == 'a' || currentChar == 'e' ||currentChar == 'i' ||currentChar == 'o' ||currentChar == 'u'){
                    vowels++;
                } else {
                    consonant++;
                }
            }

            if (vowels == consonant) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
