import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] numbersStr = reader.readLine().split("\\s+");

        int[] numbers = new int[2];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        int evenSum = 0;
        for (int i = numbers[0]; i <= numbers[1]; i++) {
            if (i % 2 == 0) {
                evenSum += i;
            }
        }

        int oddSum = 0;
        for (int i = numbers[0]; i <= numbers[1]; i++) {
            if (i % 2 == 1) {
                oddSum += i;
            }
        }

        System.out.println(Math.abs(evenSum - oddSum) % 5 + 2);
    }
}
