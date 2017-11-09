import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4 {
    private static final int MAGIC_NUMBER = -567;

    public static void main(String[] args) throws IOException {
        int number = mainLogic();
        System.out.println(number);
    }

    private static int mainLogic() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstInput = reader.readLine().split("\\s+");

        int n = Integer.parseInt(firstInput[0]);
        int lookNumber = Integer.parseInt(firstInput[1]);

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int counter = 1;

        int[] pointer = new int[]{0, 0};
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n; j++) {
                int[] nextMove = checkRight(pointer);
                if (nextMove[1] >= n || matrix[nextMove[0]][nextMove[1]] == MAGIC_NUMBER) {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    break;
                } else {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    moveRight(pointer);
                    counter++;
                }
                if (counter == lookNumber) {
                    return matrix[pointer[0]][pointer[1]];
                }
            }

            for (int j = 0; j < n; j++) {
                int[] nextMove = checkDown(pointer);
                if (nextMove[0] >= n || matrix[nextMove[0]][nextMove[1]] == MAGIC_NUMBER) {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    break;
                } else {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    moveDown(pointer);
                    counter++;
                }
                if (counter == lookNumber) {
                    return matrix[pointer[0]][pointer[1]];
                }
            }

            for (int j = 0; j < n; j++) {
                int[] nextMove = checkLeft(pointer);
                if (nextMove[1] < 0 || matrix[nextMove[0]][nextMove[1]] == MAGIC_NUMBER) {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    break;
                } else {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    moveLeft(pointer);
                    counter++;

                }
                if (counter == lookNumber) {
                    return matrix[pointer[0]][pointer[1]];
                }
            }

            for (int j = 0; j < n; j++) {
                int[] nextMove = checkUp(pointer);
                if (nextMove[0] < 0 || matrix[nextMove[0]][nextMove[1]] == MAGIC_NUMBER) {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    break;
                } else {
                    matrix[pointer[0]][pointer[1]] = MAGIC_NUMBER;
                    moveUp(pointer);
                    counter++;
                }
                if (counter == lookNumber) {
                    return matrix[pointer[0]][pointer[1]];
                }
            }
        }

        return counter;
    }

    private static void moveRight(int[] pointer) {
        pointer[1] += 1;
    }

    private static void moveDown(int[] pointer) {
        pointer[0] += 1;
    }

    private static void moveLeft(int[] pointer) {
         pointer[1] -= 1;
    }

    private static void moveUp(int[] pointer) {
        pointer[0] -= 1;
    }

    private static int[] checkRight(int[] pointer) {
        return new int[]{pointer[0], pointer[1] + 1};
    }

    private static int[] checkDown(int[] pointer) {
        return new int[]{pointer[0] + 1, pointer[1]};
    }

    private static int[] checkLeft(int[] pointer) {
        return new int[]{pointer[0], pointer[1] - 1};
    }

    private static int[] checkUp(int[] pointer) {
        return new int[]{pointer[0] - 1, pointer[1]};
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
