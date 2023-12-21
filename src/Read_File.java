package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_File {

    public int[][] getting_num_array() {

        String[] line;
        final int ROWS = 9;
        final int COLUMNS = 9;
        int[][] numbers = new int[ROWS][COLUMNS];

        try {
            File file = new File("sudoku.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                for (int i = 0; i < numbers.length; ++i) {
                    line = myReader.nextLine().trim().split(" ");
                    for (int j = 0; j < line.length; ++j) {
                        numbers[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file");
            e.printStackTrace();
        }

        return numbers;
    }
}
