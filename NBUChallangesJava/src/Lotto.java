import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Lotto {
    public static void main(String[] args) throws IOException {
        boolean answer = start();
        System.out.println(answer ? "Winning" : "Losing");
    }


    private static boolean start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int size = Integer.parseInt(input[2]);

        LinkedList<String> lines = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            lines.add(line);
        }
        String combination = reader.readLine();

        for (int i = 0; i < cols; i++) {
            StringBuilder str = new StringBuilder("");
            for (int j = 0; j < rows; j++) {
                str.append(lines.get(j).charAt(i));
            }
            lines.add(str.toString());
        }

        for (String line : lines) {
            for (int j = 0; j <= line.length() - size; j++) {
                if (line.substring(j, j + size).equals(combination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
