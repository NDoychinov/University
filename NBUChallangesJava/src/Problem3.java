import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;


public class Problem3 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        LinkedList<Integer> days = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            days.add(scan.nextInt());
        }

        Collections.sort(days, Collections.reverseOrder());

        int counter = 0;
        boolean found = false;
        for (int i = 0; i < days.size(); i++) {
            int k = days.get(i);
            if (k < i) {
                break;
            }
            counter = 0;
            for (Integer day : days) {
                if (k <= day) {
                    counter++;
                }
                if (counter == k) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        System.out.println(counter);
    }
}
