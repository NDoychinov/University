import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class DecimalToRome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int decimalNum = Integer.parseInt(reader.readLine());
        LinkedHashMap<String, Integer> nums = initializeMap();

        for (Map.Entry<String, Integer> stringIntegerEntry : nums.entrySet()) {
            for (int i = 0; i < decimalNum / stringIntegerEntry.getValue(); i++) {
                System.out.printf(stringIntegerEntry.getKey());
            }
            decimalNum %= stringIntegerEntry.getValue();
        }
    }

    private static LinkedHashMap<String, Integer> initializeMap() {
        LinkedHashMap<String, Integer> nums = new LinkedHashMap<>();
        nums.put("M", 1000);
        nums.put("CM", 900);
        nums.put("D", 500);
        nums.put("CD", 400);
        nums.put("C", 100);
        nums.put("XC", 90);
        nums.put("L", 50);
        nums.put("XL", 40);
        nums.put("X", 10);
        nums.put("IX", 9);
        nums.put("V", 5);
        nums.put("IV", 4);
        nums.put("I", 1);
        return nums;
    }
}
