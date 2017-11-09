import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Niki on 4.10.2017 г..
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            LinkedList<Double> set = new LinkedList<>();
            double s = (a + b + c) / 2d;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

            double side1 = (2d * area) / a;
            double side2 = (2d * area) / b;
            double side3 = (2d * area) / c;

            set.add(side1);
            set.add(side2);
            set.add(side3);

            Collections.sort(set, Collections.reverseOrder());

            for (Double aDouble : set) {
                System.out.printf("%.2f ", aDouble);
            }

        } else {
            System.out.println(-1);
        }
    }
}
