package src;

import java.util.Arrays;

public class FindOptionsForSquares
{
    private boolean check(int[] arr, int value)
    {
        for (int element : arr)
        {
            if (element == value)
                return true;
        }
        return false;
    }

    private int squarePosition(int x, int y)
    {
        if(x < 3)
        {
            if(y < 3)
                return 0;
            else if(y < 6)
                return 3;
            else
                return 6;
        }
        else if(x < 6)
        {
            if(y < 3)
                return 1;
            else if(y < 6)
                return 4;
            else
                return 7;
        }
        else
        {
            if(y < 3)
                return 2;
            else if(y < 6)
                return 5;
            else
                return 8;
        }
    }

    public int[][][] findOptions(int[][] board)
    {

        final int ROWS = 9;
        final int COLUMNS = 9;
        final int OPTIONS = 9;
        int[][][] options = new int[ROWS][COLUMNS][OPTIONS];

        for(int i = 0; i  < ROWS; ++i)
        {
            for(int j = 0; j  < COLUMNS; ++j)
            {
                if(board[i][j] == 0)
                {
                    for(int k = 0; k < OPTIONS; ++k)
                        options[i][j][k] = k+1;


                    for(int k = 0; k < COLUMNS; ++k)
                    {
                        if(board[i][k] != 0 && check(options[i][j], board[i][k]))
                        {
                            options[i][j][board[i][k]-1] = 0;
                        }
                    }


                    for(int k = 0; k < ROWS; ++k)
                    {
                        if(board[k][j] != 0 && check(options[i][j], board[k][j]))
                        {
                            options[i][j][board[k][j]-1] = 0;
                        }
                    }

                    int maxX = 0;
                    int maxY = 0;
                    switch (squarePosition(j, i)) {
                        case 0 -> {
                            maxY = 3;
                            maxX = 3;
                        }
                        case 1 -> {
                            maxY = 3;
                            maxX = 6;
                        }
                        case 2 -> {
                            maxY = 3;
                            maxX = 9;
                        }
                        case 3 -> {
                            maxY = 6;
                            maxX = 3;
                        }
                        case 4 -> {
                            maxY = 6;
                            maxX = 6;
                        }
                        case 5 -> {
                            maxY = 6;
                            maxX = 9;
                        }
                        case 6 -> {
                            maxY = 9;
                            maxX = 3;
                        }
                        case 7 -> {
                            maxY = 9;
                            maxX = 6;
                        }
                        case 8 -> {
                            maxY = 9;
                            maxX = 9;
                        }
                    }

                    for(int l = maxY-3; l < maxY; ++l)
                    {
                        for(int m = maxX-3; m < maxX; ++m)
                        {
                            if(board[l][m] != 0 && check(options[i][j], board[l][m]))
                            {
                                options[i][j][board[l][m]-1] = 0;
                            }
                        }
                    }

                    //System.out.println(Arrays.toString(options[i][j]));
                }
            }
        }

        return options;
    }

}
