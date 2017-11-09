import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Cars {
    public static void main(String[] args) throws IOException {
        System.out.println(start() * 10);
    }

    private static int start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        String[] input = reader.readLine().split("\\s+");

        ArrayList<Integer> cars = new ArrayList<>();
        for (String anInput : input) {
            cars.add(Integer.parseInt(anInput));
        }

        int stepCounter = 0;
        while (!checkIfSorted(cars)) {
            int emptyIndex = cars.indexOf(0);

            int swapCarIndex = 0;
            if (emptyIndex != 0) {
                swapCarIndex = cars.indexOf(emptyIndex);
            } else {
                //Looks better but slower
                //swapCarIndex = cars.stream().filter(i -> !Objects.equals(cars.get(i), i)).findFirst().get();
                for (int i = 0; i < cars.size(); i++) {
                    if (cars.get(i) != i) {
                        swapCarIndex = i;
                        break;
                    }
                }
            }

            swap(cars, emptyIndex, swapCarIndex);
            stepCounter++;
        }

        return stepCounter;
    }

    private static boolean checkIfSorted(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
