import java.util.Scanner;

/**
 * Created by Niki on 15.9.2017 г..
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = Integer.parseInt(scan.nextLine());
        long sum = 0;

        if (n > 0) {
            for (long i = 0; i <= n; i++) {
                sum += i;
            }
        } else {
            for (long i = 1; i >= n; i--) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
