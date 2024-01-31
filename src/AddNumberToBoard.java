package src;

public class AddNumberToBoard {

    public boolean changed = false;

    public int[][] addNum(int [][] board, int [][][] options) {

        int onlyNumber = 0;

        for(int i = 0; i  < 9; ++i) {
            for(int j = 0; j < 9; ++j) {

                for(int k = 0; k < 9; ++k) {
                    if(options[i][j][k] != 0)
                        ++onlyNumber;
                }

                if(onlyNumber == 1) {
                    changed = true;
                    for(int k = 0; k < 9; ++k) {
                        if(options[i][j][k] != 0) {
                            board[i][j] = (k+1);
                            break;
                        }
                    }
                }

                onlyNumber = 0;
            }
        }

        return board;
    }
}