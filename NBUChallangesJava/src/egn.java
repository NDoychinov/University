import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class egn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int amount = Integer.parseInt(reader.readLine());

        int counter = 0;
        for (int i = 0; i < amount; i++) {
            if (((Long.parseLong(reader.readLine()) / 10) % 10) % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
