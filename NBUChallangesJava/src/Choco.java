import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choco {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s");
        int p = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        int chocos = n / p;
        for (int i = 1; i <= chocos; i++) {
            if (i % k == 0) {
                chocos++;
            }
        }

        System.out.println(chocos);
    }
}
