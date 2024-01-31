package src;

import java.util.Arrays;

public class Main {

    private static boolean isSolved(int[][] board) {
        for(int i = 0; i  < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if(board[i][j]== 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] numbers;
        int[][][] options = new int[0][][];
        int[][][] tempOptions;

        ReadFile file = new ReadFile();
        FindOptionsForSquares choice = new FindOptionsForSquares();
        AddNumberToBoard add = new AddNumberToBoard();
        CutOutOptions newOptions = new CutOutOptions();

        numbers = file.gettingNumArray();

        while(!isSolved(numbers)) {

            tempOptions = options;
            options = choice.findOptions(numbers);
            options = newOptions.cutOptions(options, numbers);
            numbers = add.addNum(numbers, options);

            if(Arrays.deepEquals(tempOptions, options)) {
                System.out.println("Unsolvable.");
                break;
            }
        }


        if(isSolved(numbers)) {
            for(int i = 0; i  < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    System.out.print(numbers[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}