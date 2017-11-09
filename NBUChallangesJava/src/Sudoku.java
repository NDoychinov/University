import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {
    private static final int SUDOKU_SIZE = 9;
    private static final int MISSING_SYMBOL = 0;
    private static final int SQUARE_SIZE = SUDOKU_SIZE / 3;
    
    private static int[][] sudoku;
    private static int missingCount = 0;

    public static void main(String[] args) throws IOException {
        initializeSudoku();
        
        while (missingCount > 0) {
            for (int i = 0; i < SUDOKU_SIZE && missingCount > 0; i++) {
                //Looping through all sudoku squares
                checkSquare(i + 1);
                checkRow(i);
                checkCol(i);
            }
        }
        printSudoku();
    }
    
    
    private static void initializeSudoku() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];

        for (int i = 0; i < SUDOKU_SIZE; i++) {
            String[] inputs = reader.readLine().split("\\s");
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                int num = Integer.parseInt(inputs[j]);
                sudoku[i][j] = num;
                if (num == MISSING_SYMBOL) {
                    missingCount++;
                }
            }
        }
    }
    
    private static void checkSquare(int squareNum) {
        int[] firstEl = getSquareFirstEl(squareNum);
        int[] emptyIndex = new int[] {-1, -1};

        int sum = 0;
        for (int i = firstEl[0]; i < firstEl[0] + SQUARE_SIZE; i++) {
            for (int j = firstEl[1]; j < firstEl[1] + SQUARE_SIZE; j++) {
                int currentEl = sudoku[i][j];
                sum += currentEl;

                if (currentEl == 0) {
                    if (emptyIndex[0] != -1) {
                        return;
                    }
                    emptyIndex[0] = i;
                    emptyIndex[1] = j;
                }
            }
        }

        if (emptyIndex[0] != -1) {
            int missingNum = ((SUDOKU_SIZE * (SUDOKU_SIZE + 1)) / 2) - sum;
            sudoku[emptyIndex[0]][emptyIndex[1]] = missingNum;
            missingCount--;
        }
    }

    private static void checkRow(int row){
        int[] emptyIndex = new int[] {-1, -1};

        int sum = 0;
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            int currentEl = sudoku[row][i];
            sum += currentEl;

            if (currentEl == 0) {
                if (emptyIndex[0] != -1) {
                    return;
                }

                emptyIndex[0] = row;
                emptyIndex[1] = i;
            }
        }

        if (emptyIndex[0] != -1) {
            int missingNum = 45 - sum;
            sudoku[emptyIndex[0]][emptyIndex[1]] = missingNum;
            missingCount--;
        }
    }

    private static void checkCol(int col){
        int[] emptyIndex = new int[] {-1, -1};

        int sum = 0;
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            int currentEl = sudoku[i][col];
            sum += currentEl;

            if (currentEl == 0) {
                if (emptyIndex[0] != -1) {
                    return;
                }

                emptyIndex[0] = i;
                emptyIndex[1] = col;
            }
        }

        if (emptyIndex[0] != -1) {
            int missingNum = 45 - sum;
            sudoku[emptyIndex[0]][emptyIndex[1]] = missingNum;
            missingCount--;
        }
    }

    //Finds a square top left element (first element)
    private static int[] getSquareFirstEl(int squareNum) {
        switch (squareNum) {
            case 1: return new int[] {0, 0};
            case 2: return new int[] {0, SQUARE_SIZE};
            case 3: return new int[] {0, SQUARE_SIZE * 2};
            case 4: return new int[] {SQUARE_SIZE, 0};
            case 5: return new int[] {SQUARE_SIZE, SQUARE_SIZE};
            case 6: return new int[] {SQUARE_SIZE, SQUARE_SIZE * 2};
            case 7: return new int[] {SQUARE_SIZE * 2, 0};
            case 8: return new int[] {SQUARE_SIZE * 2, SQUARE_SIZE};
            case 9: return new int[] {SQUARE_SIZE * 2, SQUARE_SIZE * 2};
            default: throw new IllegalArgumentException("Not valid square num");
        }
    }

    private static void printSudoku() {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            for (int j = 0; j < SUDOKU_SIZE; j++) {
                System.out.printf(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
