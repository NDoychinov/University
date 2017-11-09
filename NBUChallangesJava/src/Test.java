import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split("\\s");

        Integer[] days = new Integer[n];
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(days, Comparator.reverseOrder());

        int indicator = n;
        for (int i = 0; i < days.length; i++) {
            int k = days[i];
            if (i + 1 >= k) {
                indicator = k;
                break;
            }
        }

        System.out.println(indicator);
    }
}
